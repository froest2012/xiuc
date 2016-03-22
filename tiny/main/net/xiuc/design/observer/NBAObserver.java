package net.xiuc.design.observer;

/**
 * Created by 秀川 on 16/3/22.
 */
public class NBAObserver extends Observer {

    public NBAObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.action()+","+name+"回去工作");
    }
}
