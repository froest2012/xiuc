package net.xiuc.design.visitor;

/**
 * Created by 秀川 on 16/4/8.
 */
public class MainTest {
    public static void main(String[] args) {
        DataStructure dataStructure = new DataStructure();
        dataStructure.addElement(new ConcreteElementA());
        dataStructure.addElement(new ConcreteElementB());

        ConcreteAVisitor visitorA = new ConcreteAVisitor();
        ConcreteBVisitor visitorB = new ConcreteBVisitor();

        dataStructure.accpt(visitorA);
        dataStructure.accpt(visitorB);

    }

}
