package net.xiuc.design.proxy;

/**
 * 代理实现接口, 控制对真实对象的访问
 *
 * Created by 秀川 on 16/3/12.
 */
public class Proxy implements Subject{
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject){
        if(realSubject == null){
            this.realSubject = new RealSubject();
        }else {
            this.realSubject = realSubject;
        }
    }

    public void request() {
        realSubject.request();
    }
}
