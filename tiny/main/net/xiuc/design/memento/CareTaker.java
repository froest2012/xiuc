package net.xiuc.design.memento;

/**
 * Created by 秀川 on 16/3/28.
 */
public class CareTaker {

    private Memento memento;

    public void setMemento(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento(){
        return memento;
    }
}
