package net.xiuc.design.decorator;

/**
 * 装饰器的一种实现,用于添加信息
 * Created by 秀川 on 16/3/10.
 */
public class ConcreteComponentA extends Decorator {

    private String state;

    @Override
    public void operate() {
        super.operate();
        state = "添加的状态";
        System.out.println(state);
    }
}
