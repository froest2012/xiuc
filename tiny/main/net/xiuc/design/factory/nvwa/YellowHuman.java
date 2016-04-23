package net.xiuc.design.factory.nvwa;

/**
 * Created by 秀川 on 16/4/23.
 */
public class YellowHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("yellow human");
    }

    @Override
    public void talk() {
        System.out.println("yellow human talk with chinese");
    }
}
