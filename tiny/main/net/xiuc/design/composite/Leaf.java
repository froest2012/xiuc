package net.xiuc.design.composite;

/**
 * Created by 秀川 on 16/3/30.
 */
public class Leaf extends BaseComponent {

    public Leaf(String name){
        super(name);
    }

    @Override
    public void display(int depth) {
        while (depth-- > 0){
            System.out.print("-");
        }
        System.out.println(getName());
    }
}
