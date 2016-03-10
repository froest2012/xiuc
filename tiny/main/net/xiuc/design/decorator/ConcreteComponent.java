package net.xiuc.design.decorator;

/**
 * 被添加动态信息的类
 */
public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("ConcreteComponent");
    }
}