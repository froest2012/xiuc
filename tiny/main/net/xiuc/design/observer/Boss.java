package net.xiuc.design.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 被观察对象
 *
 * Created by 秀川 on 16/3/22.
 */
public class Boss implements Subject {

    private List<Observer> observerList = Lists.newArrayList();

    private String action; //被观察对象的事件

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observerList){
            observer.update();
        }
    }

    @Override
    public String action() {
        return action;
    }

    @Override
    public void set(String action) {
        this.action = action;
    }
}
