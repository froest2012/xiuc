package net.xiuc.design.memento;

/**
 * Created by 秀川 on 16/3/28.
 */
public class Memento {

    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
