package com.example.threaddemo.mythread;


// 创建线程方式一：继承Thread类，重新run()方法，调用start开启线程
// 注意：线程开启不一定立即执行，由CPU调度执行
public class TestThread1 extends Thread {

    @Override
    public void run(){
      //run 方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码----"+i);
        }
    }

    public static void main(String[] args) {
        // main 线程，主线程

        // 创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        // 调用start()方法开启线程
        testThread1.run();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程---"+i);
        }
    }
}
