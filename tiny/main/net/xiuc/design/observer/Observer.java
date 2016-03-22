package net.xiuc.design.observer;

/**
 * Created by 秀川 on 16/3/22.
 */
public abstract class Observer {
    protected String name;
    protected Subject subject;//被观察的对象

    public Observer(String name, Subject subject){
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();
}
