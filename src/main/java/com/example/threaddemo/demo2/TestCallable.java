package com.example.threaddemo.demo2;

import com.example.threaddemo.mythread.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程创建方式三：实现callable接口
 * callable的好处：可以定义返回值，可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }


    // 网络图片地址
    private String url;
    // 保存的文件名
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Fc2%2F88%2F07%2Fc2880735e9b777937f8453e4bf1d91f9.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1645687357&t=cc453cca4c2a7cb906db551c710f52d5", "1.JPG");
        TestCallable t2 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Fed%2F20%2F07%2Fed2007135110a9db844d74fcbaa825fc.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1645687357&t=33e9ef32651b954c6a2aa7c27a189d95", "2.JPG");
        TestCallable t3 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2F44%2F65%2Ff8%2F4465f84e9ac886acd9f7702f60fd7f1b.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1645687357&t=e9121c01fa330813724c95f3f6f1c2ff", "3.JPG");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 关闭服务
        ser.shutdownNow();


    }


}




// 下载器
class WebDownloader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
