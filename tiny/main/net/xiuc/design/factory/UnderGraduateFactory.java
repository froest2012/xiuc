package net.xiuc.design.factory;

/**
 * 大学生工厂类
 * Created by 秀川 on 16/3/13.
 */
public class UnderGraduateFactory implements IFactory {
    public Leifeng creaeFactory() {
        return new Undergraduate();
    }
}
