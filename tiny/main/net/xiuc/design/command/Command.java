package net.xiuc.design.command;

/**
 * 抽象的命令
 * Created by 秀川 on 16/4/5.
 */
public abstract class Command {

    protected Receiver receiver;

    public abstract void execute();
}
