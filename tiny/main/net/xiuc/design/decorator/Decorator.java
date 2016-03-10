package net.xiuc.design.decorator;

/**
 * 装饰器
 */
public class Decorator extends Component {
    private Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operate() {
        if(component != null){
            component.operate();
        }
    }
}