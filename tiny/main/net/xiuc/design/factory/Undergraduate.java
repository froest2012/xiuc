package net.xiuc.design.factory;

/**
 * 大学生类
 * Created by 秀川 on 16/3/13.
 */
public class Undergraduate implements Leifeng {
    public void sweep() {
        System.out.println(Undergraduate.class + "扫地");
    }

    public void buyRice() {
        System.out.println(Undergraduate.class + "买米");
    }

    public void wash() {
        System.out.println(Undergraduate.class + "洗衣");
    }
}
