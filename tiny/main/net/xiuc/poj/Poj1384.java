package net.xiuc.poj;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

/**
 * TODO 还没调试完
 * Created by 秀川 on 16/3/20.
 */
public class Poj1384 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int nt = in.nextInt();
            for(int l = 0; l < nt; l++){
                int pw = in.nextInt();
                int sw = in.nextInt();
                int v = sw - pw;
                int n = in.nextInt();
                int[] cost = new int[n + 1];
                int[] weight = new int[n + 1];
                for(int i = 1;i <= n; i++){
                    weight[i] = in.nextInt();
                    cost[i] = in.nextInt();
                }

                System.out.println(completePack011binary(cost, weight, v));
            }

        }
    }

    private static int pack011(int[][] f, int[] cost, int[] weight, int v) {
        for (int i = 1; i < cost.length; i++) {
            for (int j = v; j >= 0; j--) {
                if (j >= cost[i]) {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - cost[i]] + weight[i]);
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[cost.length - 1][v];
    }

    private static int completePack011binary(int[] cost, int[] weight, int v){
        List<Integer> realCost = Lists.newArrayList();
        List<Integer> realWeight = Lists.newArrayList();
        for(int i = 1; i < cost.length; i++){
            int k = 1;
            while (cost[i] * k <= v){
                realCost.add(cost[i] * k);
                realWeight.add(weight[i] * k);
                k *= 2;
            }
        }
        realCost.add(0, 0);
        realWeight.add(0, 0);
        int[] costArray = new int[realCost.size()];
        int[] weightArray = new int[realWeight.size()];
        for(int i = 0; i < realCost.size(); i++){
            costArray[i] = realCost.get(i);
            weightArray[i] = realWeight.get(i);
        }
        int[][] f = new int[costArray.length][v + 1];
        for(int i = 0; i < costArray.length; i++){
            for(int j = 0; j < weightArray.length; j++){
                f[i][j] = 999999999;
            }
        }
        return pack011(f, costArray, weightArray, v);
    }

    private static void print011(int[][] f, int[] cost, int[] weight, int i, int j, List<Integer> result) {
        if (i < 1) {
            return;
        }
        if (j >= cost[i] && f[i][j] == f[i - 1][j - cost[i]] + weight[i]) {
            result.add(i);
            print011(f, cost, weight, i - 1, j - cost[i], result);
        } else {
            print011(f, cost, weight, i - 1, j, result);
        }
    }
}
