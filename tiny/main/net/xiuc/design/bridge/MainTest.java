package net.xiuc.design.bridge;

/**
 * 桥接模式
 * Created by 秀川 on 16/4/4.
 */
public class MainTest {
    public static void main(String[] args) {
        Abstractor abstractor = new Abstractor();

        abstractor.setImplemetor(new Aimplemetor());
        abstractor.operate();

        abstractor.setImplemetor(new Bimplemetor());
        abstractor.operate();
    }
}
