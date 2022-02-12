package com.example.threaddemo.syn;

// juc java 并发包
import java.util.concurrent.CopyOnWriteArrayList;

// 测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) {
        // 线程安全
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 10000
        System.out.println(list.size());
    }

}
