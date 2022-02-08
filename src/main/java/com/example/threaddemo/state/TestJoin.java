package com.example.threaddemo.state;

/***
 * 测试join方法，想像成插队，也可以理解为线程等待，主线程等待当前线程执行完之后继续执行
 */
public class TestJoin implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程VIP来了" + i);
        }
    }


    // 观察的结果是两个线程同时并发跑，当需要强制执行的线程执行完了再到join就不执行了，当强制执行的线程没有执行完，满足条件时会继续执行调用join的线程，cpu被指明先执行join的线程，完之后执行其它线程
    public static void main(String[] args) throws InterruptedException {
        // 启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 200; i++) {
            if (i == 100) {
                // 插队线程，让主线程暂停执行，强制执行它自己
                thread.join();
            }
            System.out.println("main" + i);
        }


    }
}
