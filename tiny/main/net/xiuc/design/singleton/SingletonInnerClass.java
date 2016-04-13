package net.xiuc.design.singleton;

/**
 * 内部静态类单例
 * 懒汉式
 * 在SingletonInnerClass类加载的时候, 实例不一定被实例化, 在调用 {@link SingletonInnerClass#getInstance()} 的时候才会装载SingletonHolder,
 * 并实例化instance
 * Created by 秀川 on 16/4/13.
 */
public class SingletonInnerClass {

    private SingletonInnerClass(){

    }

    public SingletonInnerClass getInstance() {
        return SingletonHolder.singeleton;
    }

    private static class SingletonHolder {
        private static final SingletonInnerClass singeleton = new SingletonInnerClass();
    }

}
