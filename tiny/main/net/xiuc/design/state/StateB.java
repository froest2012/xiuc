package net.xiuc.design.state;

/**
 * Created by 秀川 on 16/3/25.
 */
public class StateB implements State {

    @Override
    public void handle(Context context) {
        System.out.println("状态B");
        context.setState(new StateC());
    }
}
