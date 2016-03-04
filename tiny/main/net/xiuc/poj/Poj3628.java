package net.xiuc.poj;

import java.util.Scanner;

/**
 * Poj3628
 * 01背包...不加常数优化的代码能过,加了常数优化居然过不了了..
 * 我也是醉了
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
            int v = sum;
            int[] f = new int[v + 1];
            int costLen = cost.length;
            for (int i = 1; i < costLen; i++) {
                for (int j = v; j >= cost[i]; j--) {
                    f[j] = Math.max(f[j], f[j - cost[i]] + cost[i]);
                }
            }
            int min = 999999999;
            for (int i = 0; i <= v; i++) {
                if(f[i] >= b) {
                    min = Math.min(min, f[i] - b);
                }
            }
            System.out.println(min);
        }
    }
}
