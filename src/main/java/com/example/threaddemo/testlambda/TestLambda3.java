package com.example.threaddemo.testlambda;


/**
 * lambda表达式的推导 ： 1、定义类实现接口，重写方法 2、定义静态内部类实现接口，重写方法 3、定义局部内部类实现接口，重写方法
 * 4、定义匿名内部类（new 接口或者继承父类），重写方法 5、用lambda表达式简化，去掉重写方法等重复内容
 */
public class TestLambda3 {


    public static void main(String[] args) {
        ILove love = null;
//        // 局部内部类
//        class Love implements ILove {
//
//            @Override
//            public void love(int a) {
//                System.out.println("i love you--->" + a);
//            }
//        }
//        ILove love = new Love();
//        love.love(2);
        // 匿名内部类
//        ILove love = new ILove() {
//            @Override
//            public void love(int a) {
//                System.out.println("i love you--->" + a);
//            }
//        };
//        love.love(2);
        // 匿名内部类转lambda表达式
        love = (int a) -> System.out.println("i love you--->" + a);
        // 简化1：去掉参数类型
        love = (a) -> System.out.println("i love you--->" + a);
         //简化2： 简化括号
        love = a -> {System.out.println("i love you--->" + a);};
        //简化3： 去掉花括号
        love = a -> System.out.println("i love you--->" + a);
        // 总结： lambda表达式只能有一行代码的情况下才能简化成一行，如果有多行，那么就用代码块包裹。
        // 前提是接口为函数式接口
        // 多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号

        love.love(521);

    }
}

interface ILove {
    void love(int a);
}
