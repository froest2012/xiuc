package net.xiuc.design.responsibilitychain;

/**
 * Created by 秀川 on 16/4/5.
 */
public class MainTest {
    public static void main(String[] args) {
        Handler concreteHanler1 = new ConcreteHandler1();
        Handler concreteHanler2 = new ConcreteHandler2();
        Handler concreteHanler3 = new ConcreteHandler3();

        concreteHanler1.setHandler(concreteHanler2);
        concreteHanler2.setHandler(concreteHanler3);

        concreteHanler1.request(23);
        concreteHanler1.request(16);
        concreteHanler1.request(8);

    }
}
