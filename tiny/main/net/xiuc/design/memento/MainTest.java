package net.xiuc.design.memento;

/**
 * Created by 秀川 on 16/3/28.
 */
public class MainTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("ON");
        originator.show();

        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.createMemento());

        originator.setState("OFF");
        originator.show();

        originator.setMemento(careTaker.getMemento());
        originator.show();
    }
}
