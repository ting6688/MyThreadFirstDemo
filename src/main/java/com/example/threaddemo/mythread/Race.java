package com.example.threaddemo.mythread;

// 龟兔赛跑
public class Race implements Runnable {

    // 胜利者
    private static String winner;

    @Override
    public void run() {
        // 首先来个赛道距离，然后离终点越来越近
        // 判断比赛是否结束
        // 打印出胜利者
        // 龟兔赛跑开始
        // 故事中乌龟是赢的，兔子需要睡觉，所以我们来模拟兔子睡觉
        // 终于，乌龟赢得了比赛
        for (int i = 0; i <= 100; i++) {
            // 模拟兔子睡觉，胜利者是乌龟
            if(Thread.currentThread().getName().equals("兔子") && i%10 == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 判断比赛是否结束
            boolean flag = gameOver(i);
            // 如果比赛结束了，就停止程序
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "步");
        }
    }

    // 判断是否完成比赛
    private boolean gameOver(int steps){
        if(winner !=null){
            // 已经存在胜利者了
            return true;
        }
        if(steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
