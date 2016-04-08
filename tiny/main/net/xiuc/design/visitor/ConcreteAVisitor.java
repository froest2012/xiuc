package net.xiuc.design.visitor;

/**
 * Created by 秀川 on 16/4/8.
 */
public class ConcreteAVisitor implements Visitor {

    @Override
    public void concreteElementA(Element element) {
        System.out.println("ConcreteAVisitor visit concreteElementA");
    }

    @Override
    public void concreteElementB(Element element) {
        System.out.println("ConcreteAVisitor visit concreteElementB");
    }
}
