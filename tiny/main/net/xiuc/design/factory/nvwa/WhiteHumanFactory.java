package net.xiuc.design.factory.nvwa;

/**
 * 白种人创建工厂
 * Created by 秀川 on 16/4/23.
 */
public class WhiteHumanFactory implements AbstractFactory {
    @Override
    public IHuman createHuman() {
        return new WhiteHuman();
    }
}
