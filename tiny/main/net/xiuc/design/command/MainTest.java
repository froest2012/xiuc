package net.xiuc.design.command;

/**
 * Created by 秀川 on 16/4/5.
 */
public class MainTest {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command1 = new ConcreteCommand1(receiver);
        Command command2 = new ConcreteCommand2(receiver);

        Invoker invoker = new Invoker();
        invoker.addCommand(command1);
        invoker.addCommand(command2);

        invoker.notifyCommand();
    }
}
