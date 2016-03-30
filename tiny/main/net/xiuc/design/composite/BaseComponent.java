package net.xiuc.design.composite;

/**
 * Created by 秀川 on 16/3/30.
 */
public abstract class BaseComponent {
    private String name;

    public BaseComponent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display(int depth);

}
