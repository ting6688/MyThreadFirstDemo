package com.example.threaddemo.staticproxy;


/**
 * 静态代理：实现婚庆公司帮忙结婚
 * 静态代理模式总结：真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实对象
 */

// 好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事情
public class StaticProxy {

    public static void main(String[] args) {

        new  Thread( () -> System.out.println("我爱你")).start();

        // 你要结婚
        new WeddingCompany(new You()).HappyWeeding();

    }
}

// 接口和类的区别
interface Marry {

    // 问题：接口中的方法名如何大小写？
    void HappyWeeding();
}

// 真实角色，你去结婚
class You implements Marry {

    @Override
    public void HappyWeeding() {
        System.out.println("小张要结婚了，好开心");
    }
}

// 婚庆公司，代理角色，帮助你结婚
class WeddingCompany implements Marry {

    // 代理谁 --》真实目标角色
    private Marry target;

    // 不明白此处为啥是Marry类型
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyWeeding() {
        before();
        target.HappyWeeding();
        after();

    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置婚礼现场");
    }
}