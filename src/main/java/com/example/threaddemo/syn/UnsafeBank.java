package com.example.threaddemo.syn;


// 不安全的取钱
// 两个人去银行取钱，账户
public class UnsafeBank {

    public static void main(String[] args) {
        // 账户
        Account account = new Account(100, "结婚基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");
        you.start();
        girlFriend.start();
    }

}

class Account {

    // 余额
     int money;
    // 卡号
     String name;


    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行：模拟取款
class Drawing extends Thread {
    // 账户
    Account account;
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        // todo 什么时候用super?,表示使用父类的名字
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        // 判断有没有钱
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }
        // sleep会放大问题的发生性
//        结婚基金余额为：50
//        你手里的钱：50
//        结婚基金余额为：-50
//        girlFriend手里的钱：100
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 卡内余额 = 余额 - 你取的钱
        account.money = account.money - drawingMoney;
        // 你手里的钱
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name + "余额为：" + account.money);
        // Thread.currentThread().getName() = this.getName()
        System.out.println(this.getName() + "手里的钱：" + nowMoney);
    }


}
