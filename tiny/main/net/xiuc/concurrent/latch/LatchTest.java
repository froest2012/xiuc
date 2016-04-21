package net.xiuc.concurrent.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by 秀川 on 16/4/22.
 */
public class LatchTest {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(4);

        CountDownLatch latch = new CountDownLatch(3);

        executor.execute(new LatchWorker("张三", latch));
        executor.execute(new LatchWorker("李四", latch));
        executor.execute(new LatchWorker("王五", latch));

        executor.execute(new Boss(latch));

    }
}
