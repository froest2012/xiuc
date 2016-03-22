package net.xiuc.design.builder;

/**
 * Created by 秀川 on 16/3/22.
 */
public class Director {

    public void make(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
