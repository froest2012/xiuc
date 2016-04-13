package net.xiuc.design.singleton;

/**
 * 懒汉式单例
 * 这种单利模式在单线程场景下是可以使用的,但是如果随着业务发展变成多线程环境,那就无法使用了
 * {@link SingletonExample1MainTest}
 * <p/>
 * Created by 秀川 on 16/4/13.
 */
public class SingletonExample1 {

    private static SingletonExample1 instance;

    private SingletonExample1() {
    }

    /**
     * 线程不安全写法
     * 多个线程同时调用getInstance,可能会产生多个instance
     */
//    public static SingletonExample1 getInstance() {
//        if (instance == null) {
//            instance = new SingletonExample1();
//        }
//        return instance;
//    }

    /**
     * 线程安全写法
     * 多线程环境下比较占资源,绝大部分情况下是不需要同步的
     * @return
     */
//    public static synchronized SingletonExample1 getInstance(){
//        if(instance == null){
//            instance = new SingletonExample1();
//        }
//        return instance;
//    }

    /**
     * 双重检查锁定, 线程安全, 效率低
     * @return
     */
    public static SingletonExample1 getInstance() {
        if(instance == null) {
            synchronized (SingletonExample1.class){
                if(instance == null) {
                    instance = new SingletonExample1();
                }
            }
        }
        return instance;
    }
}
