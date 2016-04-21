package net.xiuc.concurrent.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 秀川 on 16/4/22.
 */
public class Boss implements Runnable {

    private CountDownLatch latch;

    public Boss(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("等待所有的工人完工");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有的员工都干完了,开始下一步工作检查");
    }
}
