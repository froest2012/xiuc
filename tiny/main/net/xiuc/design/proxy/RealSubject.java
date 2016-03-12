package net.xiuc.design.proxy;

/**
 * 真实对象实现接口
 *
 * Created by 秀川 on 16/3/12.
 */
public class RealSubject implements Subject {
    public void request() {
        System.out.println("RealSubject发出请求");
    }
}
