package net.xiuc.design.builder;

/**
 * Created by 秀川 on 16/3/22.
 */
public class MainTest {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        director.make(builder1);
        Product p1 = builder1.getProduct();
        p1.show();

        director.make(builder2);
        Product p2 = builder2.getProduct();
        p2.show();
    }
}
