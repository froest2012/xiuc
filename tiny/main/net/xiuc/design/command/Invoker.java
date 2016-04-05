package net.xiuc.design.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 搜集并执行命令的人
 * Created by 秀川 on 16/4/5.
 */
public class Invoker {

    private List<Command> commandList = Lists.newArrayList();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void removeCommand(Command command){
        commandList.remove(command);
    }

    public void notifyCommand(){
        for(Command command : commandList){
            command.execute();
        }
    }
}
