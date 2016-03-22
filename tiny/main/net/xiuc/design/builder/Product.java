package net.xiuc.design.builder;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by 秀川 on 16/3/22.
 */
public class Product {
    private List<String> parts = Lists.newArrayList();

    public void addPart(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("show");
        for(String part : parts){
            System.out.println(part);
        }
    }
}
