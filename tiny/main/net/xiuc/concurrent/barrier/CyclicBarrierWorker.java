package net.xiuc.concurrent.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 并发编程栅栏测试代码
 * 适用于多线程操作中, 多种资源同时准备就绪, 才能开始后面的操作
 * 比如一个功能要上线,只有产品,设计,开发, 测试都完成了以后才可以上线
 * CyclicBarrier 其实类似于 @see CountDownLatch
 * Created by 秀川 on 16/4/22.
 */
public class CyclicBarrierWorker implements Runnable {

    private Integer i;

    private CyclicBarrier barrier;

    public CyclicBarrierWorker(Integer i, CyclicBarrier barrier){
        this.i = i;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("第" + i + "个人正等待");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
