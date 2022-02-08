package com.example.threaddemo.testlambda;


/**
 * lambda表达式的推导 ： 1、定义类实现接口，重写方法 2、定义静态内部类实现接口，重写方法 3、定义局部内部类实现接口，重写方法
 * 4、定义匿名内部类（new 接口或者继承父类），重写方法 5、用lambda表达式简化，去掉重写方法等重复内容
 */
public class TestLambda3 {

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(2);
    }
}

interface ILove{
    void love(int a);
}
class Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("i love you--->" + a);
    }
}