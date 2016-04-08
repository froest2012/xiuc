package net.xiuc.design.visitor;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by 秀川 on 16/4/8.
 */
public class DataStructure {
    List<Element> elementList = Lists.newArrayList();

    public void addElement(Element element){
        elementList.add(element);
    }

    public void removeElement(Element element){
        elementList.remove(element);
    }

    public void accpt(Visitor visitor){
        for(Element element : elementList){
            element.accept(visitor);
        }
    }
}
