package com.example.threaddemo.testlambda;

// 有的类只用一次，就不用在外面定义三个类了，可以把类定义在一个类里面
public class TestLambda2 {

    // 3、静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        //定义接口的实现类
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();


        // 4、局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        // 先定义4，再使用，否则会出现找不到类的问题
        like = new Like3();
        like.lambda();

        // 5、匿名内部类 没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");

            }
        }; // 因为是一行语句，所以结尾要用分号
        // i like lambda4
        like.lambda();

        // 6、用lambda简化(因为需要重写的方法只有一个是固定的，所以可以省去)
        like = () -> {
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

//1、 定义一个函数式接口
interface ILike {
    void lambda();
}

//2、 实现类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}

