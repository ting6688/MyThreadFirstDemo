package com.example.threaddemo.mythread;



// 创建线程方式2：实现runnable 接口，重写run方法，执行线程需要丢入Runnable接口实现类，调用start方法
// 因为Java单继承，所以推荐使用runnable接口,方便同一个对象被多个线程使用    
public class TestThread3 implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码----"+i);
        }
    }

    public static void main(String[] args) {
        // main线程，主线程
        // 创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        // 创建一个线程对象,通过线程对象来开启我们的线程，代理
//        Thread thread = new Thread(testThread3);
//        thread.start();
          // 上面两行的简写方式
          new Thread(testThread3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程----" +i);
        }
    }
}
