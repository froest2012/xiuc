package net.xiuc.design.command;


/**
 * Created by 秀川 on 16/4/5.
 */
public class ConcreteCommand1 extends Command {

    public ConcreteCommand1(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.executeCommand1();
    }
}
