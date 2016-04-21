package net.xiuc.concurrent.barrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by 秀川 on 16/4/22.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        int num = 10;
        CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println("条件已经成熟,开始干活");
            }
        });

        for(int i = 1; i <= num; i++){
            new Thread(new CyclicBarrierWorker(i, barrier)).start();
        }
    }
}
