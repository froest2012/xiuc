package net.xiuc.concurrent.latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 闭锁用于等待多个事件的完成, 事件完成,计数器自减, 等到计数器减到零,闭锁状态打开
 * 闭锁的状态是一次性的, 相当于是关闭的大门,一旦打开就一直打开了
 *
 * 而栅栏用于等待多个线程, 多个线程同时达到某个状态, 开始共同执行下面的任务
 * Created by 秀川 on 16/4/22.
 */
public class LatchWorker implements Runnable {

    private String name;

    private CountDownLatch latch;

    public LatchWorker(String name, CountDownLatch latch){
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(name + "正在干活");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
