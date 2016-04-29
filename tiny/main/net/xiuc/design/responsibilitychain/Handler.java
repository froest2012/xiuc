package net.xiuc.design.responsibilitychain;

/**
 * Created by 秀川 on 16/4/5.
 */
public abstract class Handler {

    private Handler next;

    public void setHandler(Handler handler){
        this.next = handler;
    }

    public Handler getNext(){
        return next;
    }

    public abstract void request(int i);
}
