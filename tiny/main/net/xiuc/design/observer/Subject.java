package net.xiuc.design.observer;

/**
 * 被观察对象需实现的方法
 *
 * Created by 秀川 on 16/3/22.
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
    String action();
    void set(String action);
}
