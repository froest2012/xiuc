package net.xiuc.design.decorator;

/**
 * 装饰器的一种实现,用于添加信息
 * Created by 秀川 on 16/3/10.
 */
public class ConcreteComponentB extends Decorator{

    @Override
    public void operate(){
        super.operate();
        print();
    }

    private void print(){
        System.out.println("这是后面添加的方法");
    }

}
