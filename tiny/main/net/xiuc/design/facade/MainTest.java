package net.xiuc.design.facade;

/**
 * Created by 秀川 on 16/3/22.
 */
public class MainTest {
    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade();
        facade.methodA();
        facade.methodB();
    }
}
