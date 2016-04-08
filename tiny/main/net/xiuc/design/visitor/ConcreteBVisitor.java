package net.xiuc.design.visitor;

/**
 * Created by 秀川 on 16/4/8.
 */
public class ConcreteBVisitor implements Visitor {
    @Override
    public void concreteElementA(Element element) {
        System.out.println("ConcreteBVisitor visit concreteElementA");
    }

    @Override
    public void concreteElementB(Element element) {
        System.out.println("ConcreteBVisitor visit concreteElementB");

    }
}
