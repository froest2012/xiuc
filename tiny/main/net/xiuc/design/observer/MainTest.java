package net.xiuc.design.observer;

/**
 * Created by 秀川 on 16/3/22.
 */
public class MainTest {
    public static void main(String[] args) {
        Boss boss = new Boss();//被监听对象

        StockObserver stock = new StockObserver("小李", boss); //监听者
        NBAObserver nba = new NBAObserver("小王",boss);// 监听者

        boss.attach(stock); //添加监听者
        boss.attach(nba);

        boss.set("老板回来了");
//        boss.detach(nba);
        boss.notifyObserver();//事件触发
    }
}
