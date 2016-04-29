package net.xiuc.design.responsibilitychain.example;

/**
 * Created by 秀川 on 16/4/25.
 */
public abstract class Handler {

    public static final int FATHER_LEVEL_REQUEST = 1;
    public static final int HUSBAND_LEVEL_REQUEST = 1;
    public static final int SON_LEVEL_REQUEST = 1;

    private int level = 0;

    private Handler nextHandler;

    public Handler(int level){
        this.level = level;
    }

    public final void handleMessage(IWomen women){
        if(this.level == women.getType()){
            response(women);
        }else {
            if(this.nextHandler != null) {
                this.nextHandler.handleMessage(women);
            }else {
                System.out.println("------------------------");
                System.out.println("没地方请示了..");
            }
        }
    }

    public abstract void response(IWomen women);

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
