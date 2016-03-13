package net.xiuc.design.factory;

/**
 * 社区志愿者工厂类
 * Created by 秀川 on 16/3/13.
 */
public class VolunteerFactory implements IFactory {
    public Leifeng creaeFactory() {
        return new Volunteer();
    }
}
