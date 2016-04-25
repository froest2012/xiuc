package net.xiuc.design.command.example;

/**
 * Created by 秀川 on 16/4/26.
 */
public class Husband extends Handler {
    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示---------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是:同意");
    }
}
