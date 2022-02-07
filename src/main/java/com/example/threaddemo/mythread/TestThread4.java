package com.example.threaddemo.mythread;

// 多个线程操作同一个资源的情况下，线程不安全，线程紊乱
public class TestThread4 implements Runnable{

    // 票数
    private int ticketNums = 10;
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
                break;
            }
            //  模拟延时
            // 模拟延时后出现的问题： 会有两个人拿到同一张票的情况
//            小明-->拿到了第6票
//            小龙-->拿到了第5票
//            小明-->拿到了第5票
//            小婷-->拿到了第5票
//            小龙-->拿到了第4票
//            小明-->拿到了第4票
//            小婷-->拿到了第4票
//            小龙-->拿到了第3票
//            小明-->拿到了第2票
//            小婷-->拿到了第1票
//            小龙-->拿到了第0票
//            小明-->拿到了第0票
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第"+ ticketNums-- + "票" );
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();
        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"小婷").start();
        new Thread(testThread4,"小龙").start();
        // 结果：
//        小明-->拿到了第9票
//        小明-->拿到了第7票
//        小明-->拿到了第6票
//        小龙-->拿到了第8票
//        小婷-->拿到了第10票
//        小龙-->拿到了第4票
//        小龙-->拿到了第2票
//        小明-->拿到了第5票
//        小龙-->拿到了第1票
//        小婷-->拿到了第3票


    }
}
