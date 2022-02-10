package com.example.threaddemo.state;


/**
 * 测试线程优先级
 */
public class TestPriority {

    public static void main(String[] args) {
        // 主线程默认优先级 5
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

         // 先设置优先级，再启动
        // Error:Exception in thread "main" java.lang.IllegalArgumentException // 11 或1
//        try {
//            t6.setPriority(11);
//            t6.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);  // MAX_PRIORITY = 10
        t4.start();

        try {
            t5.setPriority(7);
            t5.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

// 优先级低只是意味着获得调度的概率低，并不是优先级低就不会被调用了，这都是看CPU的调度，会有【性能倒置】的问题
//        main--->5
//        Thread-0--->5
//        Thread-1--->1
//        Thread-2--->4
//        Thread-3--->10
//        Thread-4--->7

    }
}


class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}
