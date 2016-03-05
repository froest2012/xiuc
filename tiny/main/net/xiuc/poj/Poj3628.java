package net.xiuc.poj;

import java.util.Scanner;

/**
 * Poj3628
 * 01背包...
 * 常数优化只能在求背包最大价值的时候使用
 * 所以此题转化为求背包最大价值
 * Created by 秀川 on 16/3/4.
 */
public class Poj3628 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int b = in.nextInt();
            int[] cost = new int[n + 1];
            int sum = 0;
            for(int i = 1; i <= n; i++){
                cost[i] = in.nextInt();
                sum += cost[i];
            }
            int v = sum - b;
            int[] f = new int[v + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = v; j >= Math.max(cost[i],v - sum); j--) {
                    f[j] = Math.max(f[j], f[j - cost[i]] + cost[i]);
                }
                sum -= cost[i];
            }
            System.out.println(v - f[v]);
        }
    }
}
