package com.example.threaddemo.syn;

import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.List;

// 线程不安全的集合
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()-> list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 理想情况下是10000，实际上大多数时间是小于10000 的 ，因为有两个线程会重复添加在相同的索引上导致size变小，所以ArrayList也是线程不安全的
        System.out.println(list.size());
    }
    // 报错：Exception in thread "Thread-49" java.lang.ArrayIndexOutOfBoundsException: 49
    //	at java.util.ArrayList.add(ArrayList.java:465)
}
