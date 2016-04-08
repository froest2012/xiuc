package net.xiuc.design.visitor;

/**
 * Created by 秀川 on 16/4/8.
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.concreteElementB(this);
    }
}
