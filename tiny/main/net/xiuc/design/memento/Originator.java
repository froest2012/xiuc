package net.xiuc.design.memento;

/**
 * Created by 秀川 on 16/3/28.
 */
public class Originator {
    private String state;

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento memento){
        this.state = memento.getState();
    }

    public void show(){
        System.out.println("状态为: " + state);
    }

    public void setState(String state){
        this.state = state;
    }
}
