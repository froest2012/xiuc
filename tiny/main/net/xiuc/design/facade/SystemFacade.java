package net.xiuc.design.facade;

/**
 * Created by 秀川 on 16/3/22.
 */
public class SystemFacade {
    private SubSystemOne one;
    private SubSystemTwo two;
    private SubSystemThree three;

    public SystemFacade(){
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
    }
    public void methodA(){
        System.out.println("方法组A");
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }

    public void methodB(){
        System.out.println("方法组B");
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }
}
