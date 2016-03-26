package net.xiuc.design.adapter;

/**
 * Created by 秀川 on 16/3/26.
 */
public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specialRequest();
    }
}
