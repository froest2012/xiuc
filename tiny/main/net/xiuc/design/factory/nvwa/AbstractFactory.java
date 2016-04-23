package net.xiuc.design.factory.nvwa;

/**
 * 创建产品的工厂抽象
 *
 * 如果这个类变成一个真正的实体类,并且把方法变成静态方法,那么这个抽象工厂模式便变成了简单工厂模式
 *
 * Created by 秀川 on 16/4/23.
 */
public interface AbstractFactory {
    IHuman createHuman();
}
