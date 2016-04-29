package net.xiuc.design.responsibilitychain.example;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * 命令模式
 * Created by 秀川 on 16/4/26.
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        List<IWomen> womenList = Lists.newArrayList();
        for(int i = 0; i < 5; i++){
            womenList.add(new Women(random.nextInt(4), "我要出去逛街"));
        }
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();

        father.setNextHandler(husband);
        husband.setNextHandler(son);

        for(IWomen women : womenList){
            father.handleMessage(women);
        }
    }
}
