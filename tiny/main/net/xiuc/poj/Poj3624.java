package net.xiuc.poj;


import java.util.Scanner;

/**
 * 01背包
 * Created by 秀川 on 16/2/28.
 */
public class Poj3624 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] cost = new int[n + 1];
            int[] weight = new int[n + 1];
            int sum = 0;
            for(int i = 1; i <= n; i++){
                cost[i] = in.nextInt();
                weight[i] = in.nextInt();
                sum += cost[i];
            }
            int v = m;
            int[] f = new int[v + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = v; j >= Math.max(v - sum, cost[i]); j--) {
                    f[j] = Math.max(f[j], f[j - cost[i]] + weight[i]);
                }
                sum -= cost[i];
            }
            System.out.println(f[v]);
        }
    }

}
