package net.xiuc.design.composite;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by 秀川 on 16/3/30.
 */
public class Composite extends BaseComponent implements IComponent {

    private List<BaseComponent> componentList = Lists.newArrayList();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void addComponent(BaseComponent component) {
        componentList.add(component);
    }

    @Override
    public void removeComonent(BaseComponent component) {
        componentList.remove(component);
    }

    @Override
    public void display(int depth) {
        int tmp = depth;
        while (tmp-- > 0){
            System.out.print("-");
        }
        System.out.println(getName());
        for(BaseComponent comp : componentList){
            comp.display(depth + 2);
        }
    }
}
