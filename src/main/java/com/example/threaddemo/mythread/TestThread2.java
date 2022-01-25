package com.example.threaddemo.mythread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread,实现多线程同步下载图片
public class TestThread2 extends Thread {
    // 网络图片地址
    private String url;
    // 保存的文件名
    private String name;

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Fc2%2F88%2F07%2Fc2880735e9b777937f8453e4bf1d91f9.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1645687357&t=cc453cca4c2a7cb906db551c710f52d5","1.JPG");
        TestThread2 t2 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Fed%2F20%2F07%2Fed2007135110a9db844d74fcbaa825fc.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1645687357&t=33e9ef32651b954c6a2aa7c27a189d95","2.JPG");
        TestThread2 t3 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2F44%2F65%2Ff8%2F4465f84e9ac886acd9f7702f60fd7f1b.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1645687357&t=e9121c01fa330813724c95f3f6f1c2ff","3.JPG");
        // 先下载t1----顺序是可变的，同时执行每次下载的顺序都不一样
        t1.start();
        // 再下载t2
        t2.start();
        // 最后下载t3
        t3.start();

    }



}


// 下载器
class WebDownloader{
    // 下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
