package net.xiuc.design.state;

/**
 * Created by 秀川 on 16/3/25.
 */
public class Context {

    private State state;

    public Context(State state){
        this.state = state;
    }

    public void request(){
        state.handle(this);
    }

    public void setState(State state){
        this.state = state;
    }
}
