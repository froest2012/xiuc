package net.xiuc.design.composite;

/**
 * Created by 秀川 on 16/3/30.
 */
public class MainTest {
    public static void main(String[] args) {
        Composite root = new Composite("总公司");

        root.addComponent(new Leaf("财务部"));
        root.addComponent(new Leaf("技术部"));

        Composite childCompany1 = new Composite("华东区分公司");
        childCompany1.addComponent(new Leaf("技术部"));
        childCompany1.addComponent(new Leaf("财务部"));
        root.addComponent(childCompany1);

        Composite childCompany2 = new Composite("江南区分公司");
        childCompany2.addComponent(new Leaf("技术部"));
        childCompany2.addComponent(new Leaf("财务部"));
        root.addComponent(childCompany2);

        root.display(2);
    }
}
