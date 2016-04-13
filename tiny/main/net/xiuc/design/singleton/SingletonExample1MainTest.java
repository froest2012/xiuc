package net.xiuc.design.singleton;

/**
 * 不一定每次都会出现不一致的情况,但是多试几次就会出现.生成两个及以上对象
 * Created by 秀川 on 16/4/13.
 */
public class SingletonExample1MainTest {
    public static void main(String[] args) throws InterruptedException {
        for(int k = 0; k < 10000; k++) {
            SingletonExample1TestThread t = new SingletonExample1TestThread();
            for (int i = 0; i < 100; i++) {
                new Thread(t).start();
            }
            if(t.instanceList.size() > 1) {
                for (SingletonExample1 str : t.instanceList) {
                    System.out.print(str + ",");
                }
                System.out.println();
            }
        }
    }
}
