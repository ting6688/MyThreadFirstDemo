package com.example.threaddemo.testsleep;

import com.example.threaddemo.mythread.TestThread4;

/**
 * 线程休眠
 * sleep(时间)指定当前线程阻塞的毫秒数
 * sleep 存在异常InterruptedException
 * sleep时间达到后线程进入就绪状态
 * sleep可以模拟网络延时，倒计时等
 * 每一个对象都有一个锁，sleep 不会释放锁
 */
// 模拟网络延时
public class TestSleep implements Runnable {
    // 票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //  模拟网络延时，放大问题的发生性；
            // 多个线程操作同一个对象，线程不安全
            // 模拟延时后出现的问题： 会有两个人拿到同一张票的情况
//            小明-->拿到了第6票
//            小龙-->拿到了第5票
//            小明-->拿到了第5票
//            小婷-->拿到了第5票
//            小龙-->拿到了第4票
//            小明-->拿到了第4票
//            小婷-->拿到了第4票
//            小龙-->拿到了第3票
//            小明-->拿到了第2票
//            小婷-->拿到了第1票
//            小龙-->拿到了第0票
//            小明-->拿到了第0票
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4, "小明").start();
        new Thread(testThread4, "小婷").start();
        new Thread(testThread4, "小龙").start();
    }
}
