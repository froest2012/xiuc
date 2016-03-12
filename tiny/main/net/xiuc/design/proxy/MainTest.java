package net.xiuc.design.proxy;

/**
 * 测试代理
 *
 * Created by 秀川 on 16/3/12.
 */
public class MainTest {

    public static void main(String[] args){
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }
}
