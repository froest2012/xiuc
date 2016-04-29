package net.xiuc.design.responsibilitychain.example;

/**
 * Created by 秀川 on 16/4/26.
 */
public class Father extends Handler {
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("--------女儿向父亲请示---------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是:同意");
    }


}
