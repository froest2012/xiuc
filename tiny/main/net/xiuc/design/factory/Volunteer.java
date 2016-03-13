package net.xiuc.design.factory;

/**
 * 社区志愿者类
 * Created by 秀川 on 16/3/13.
 */
public class Volunteer implements Leifeng {
    public void sweep() {
        System.out.println(Volunteer.class + "扫地");
    }

    public void buyRice() {
        System.out.println(Volunteer.class + "买米");
    }

    public void wash() {
        System.out.println(Volunteer.class + "洗衣");
    }
}
