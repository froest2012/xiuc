package net.xiuc.design.command;

/**
 * 具体执行命令的人,必要的话也可以抽象
 * Created by 秀川 on 16/4/5.
 */
public class Receiver {

    public void executeCommand1(){
        System.out.println("executeCommand1");
    }

    public void executeCommand2(){
        System.out.println("executeCommand2");
    }
}
