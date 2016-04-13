package net.xiuc.design.singleton;

/**
 * Effective java作者推荐的单例写法, 线程安全且避免了反序列化重新创建对象
 * Created by 秀川 on 16/4/13.
 */
public enum  SingletonEnum {
    INSTACE;

    public SingletonEnum getInstace() {
        return INSTACE;
    }
}
