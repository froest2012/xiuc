package net.xiuc.design.singleton;

/**
 * 饿汉式单例
 * 这种方式是线程安全的,但是在类加载的时候就实例化的,没有达到延迟加载的效果
 * Created by 秀川 on 16/4/13.
 */
public class SingletonExample2 {
    private static final SingletonExample2 instance = new SingletonExample2();

    private SingletonExample2(){
    }

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
