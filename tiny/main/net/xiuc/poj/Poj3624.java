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
            int[] cost = new int[n];
            int[] weight = new int[n];
            for(int i = 0; i < n; i++){
                cost[i] = in.nextInt();
                weight[i] = in.nextInt();
            }
            int v = m;
            int[] f = new int[v + 1];
            int costLen = cost.length;
            for (int i = 0; i < costLen; i++) {
                int sum = 0;
                for (int k = i; k < costLen; k++) {
                    sum += cost[k];
                }
                int b = Math.max(v - sum, cost[i]);
                for (int j = v; j >= b; j--) {
                    f[j] = Math.max(f[j], f[j - cost[i]] + weight[i]);
                }
            }
            System.out.println(f[v]);
        }
    }

}
