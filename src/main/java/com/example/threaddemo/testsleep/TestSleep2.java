package com.example.threaddemo.testsleep;

import java.text.SimpleDateFormat;
import java.util.Date;

// 模拟倒计时
public class TestSleep2 {

    public static void main(String[] args) {
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        printCurrentTime();
    }


    // 模拟倒计时 10 9 8 7 6 5 4 3 2 1
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            System.out.println(num--);
            Thread.sleep(1000);
        }
    }

    // 打印系统当前时间
    public static void printCurrentTime(){
        // 获取系统当前时间
        Date  startTime = new Date(System.currentTimeMillis());
        while(true){
            try {
                Thread.sleep(1000);
                // 时间格式转换
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                // 更新当前时间
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
