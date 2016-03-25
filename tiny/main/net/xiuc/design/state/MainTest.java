package net.xiuc.design.state;

/**
 * Created by 秀川 on 16/3/25.
 */
public class MainTest {

    public static void main(String[] args) {
        Context context = new Context(new StateA());
        context.request();
        context.request();
        context.request();

    }

}
