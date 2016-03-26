package net.xiuc.design.adapter;

/**
 * Created by 秀川 on 16/3/26.
 */
public class MainTest {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
