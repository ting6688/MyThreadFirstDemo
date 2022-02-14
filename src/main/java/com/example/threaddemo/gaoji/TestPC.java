package com.example.threaddemo.gaoji;


import org.omg.CORBA.PRIVATE_MEMBER;

// 测试：生产者消费者模型 ---> 利用缓冲区解决：管程法
// 生产者、消费者、产品、缓冲区
public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}


// 生产者
class Productor extends Thread {
    private SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}


// 消费者
class Consumer extends Thread {
    private SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }
    // 消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了--->"+container.pop().id + "只鸡");
        }
    }
}

// 产品-鸡
class Chicken {
    public int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer {
    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        try {
            if (count == chickens.length) {
                // 如果容器满了，就通知消费者消费
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    //            return;

            }
            // 如果容器未满，将产品放入容器
            chickens[count] = chicken;
            count++;
            // 可以通知消费者消费了
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 消费者消费
    public synchronized Chicken pop() {
        Chicken chicken = null;
        try {
            if (count == 0) {
                // 如果容器为空，通知生产者生产，消费者等待
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费，count:"+count);
//            生产了10只鸡
//            消费，count:10

            // 如果容器不空，消费者消费，消费完通知生产者生产
            //  count-- 放在98行正常输出，放在100行当生产到11只鸡时会出现数组越界
//            count--; //todo为甚count-- 要放在前面
            chicken = chickens[count];
             count--;

            // 吃完了，通知生产者生产
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chicken;
    }

}
