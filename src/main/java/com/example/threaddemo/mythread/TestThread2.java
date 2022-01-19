package com.example.threaddemo.mythread;


import org.apache.commons.io.FileUtils;

import java.io.File;

// 练习Thread,实现多线程同步下载图片
public class TestThread2 {
}

class WebDownloader{
    public void downloader(String url,String name){
        FileUtils.copyURLToFile(new URL(url),new File(name));

    }
}
