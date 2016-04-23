package net.xiuc.design.factory.nvwa;

/**
 * Created by 秀川 on 16/4/23.
 */
public class WhiteHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("white human");
    }

    @Override
    public void talk() {
        System.out.println("white human talk with english");
    }
}
