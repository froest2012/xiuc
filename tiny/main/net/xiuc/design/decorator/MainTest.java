package net.xiuc.design.decorator;

/**
 * Created by 秀川 on 16/3/10.
 */
public class MainTest {

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteComponentA concreteComponentA = new ConcreteComponentA();
        ConcreteComponentB concreteComponentB = new ConcreteComponentB();

        concreteComponentA.setComponent(concreteComponent);
        concreteComponentB.setComponent(concreteComponentA);

        concreteComponentB.operate();
    }


}
