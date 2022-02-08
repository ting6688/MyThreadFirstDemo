package com.example.threaddemo.state;

// 礼让线程
// 礼让不一定成功，看CPU心情
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }

}


class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        // 正常情况下： a线程开始执行
        //a线程停止执行
        //b线程开始执行
        //b线程停止执行

        Thread.yield(); // 线程礼让
        // 线程礼让，会让当前线程暂停，其它线程执行
        // a线程开始执行
        //b线程开始执行
        //a线程停止执行
        //b线程停止执行
        System.out.println(Thread.currentThread().getName() + "线程停止执行");

    }
}