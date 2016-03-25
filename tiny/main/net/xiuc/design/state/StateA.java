package net.xiuc.design.state;

/**
 * Created by 秀川 on 16/3/25.
 */
public class StateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("状态A");
        context.setState(new StateB());
    }
}
