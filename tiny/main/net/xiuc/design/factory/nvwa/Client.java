package net.xiuc.design.factory.nvwa;

/**
 * 抽象工厂模式
 *
 * Created by 秀川 on 16/4/23.
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new YellowHumanFactory();
        IHuman yellowHuman = factory.createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();

        factory = new WhiteHumanFactory();
        IHuman whiteHuman = factory.createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();
    }
}
