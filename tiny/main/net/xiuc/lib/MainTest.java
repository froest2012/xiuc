package net.xiuc.lib;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by 秀川 on 16/3/19.
 */
public class MainTest {
    public static void main(String[] args) {
        int[] cost = {0, 4,7,9};
        int[] weight = {0, 3,10,6};
        int v = 30;
        completePackbinary(cost,weight,v);
        System.out.println();
        System.out.println(completePack01binary(cost,weight,v));
    }

    private static void completePackbinary(int[] cost, int[] weight, int v){
        List<Integer> realCost = Lists.newArrayList();
        List<Integer> realWeight = Lists.newArrayList();
        for(int i = 1; i < cost.length; i++){
            int sum = cost[i], k = 1;
            while (sum <= v){
                realCost.add(cost[i] * k);
                realWeight.add(weight[i] * k);
                k *= 2;
                sum += cost[i] * k;
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
        System.out.println(pack011(f, costArray, weightArray, v));
        List<Integer> result = Lists.newArrayList();
        print011(f, costArray, weightArray, costArray.length - 1, v, result);
        for(Integer i : result){
            System.out.print(costArray[i] + ",");
        }
        System.out.println();
        for(Integer i : result){
            System.out.print(weightArray[i] + ",");
        }
    }

    private static int pack011(int[][] f, int[] cost, int[] weight, int v) {
        for (int i = 1; i < cost.length; i++) {
            for (int j = v; j >= 0; j--) {
                if (j >= cost[i]) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - cost[i]] + weight[i]);
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[cost.length - 1][v];
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

    private static int completePack01binary(int[] cost, int[] weight, int v){
        List<Integer> realCost = Lists.newArrayList();
        List<Integer> realWeight = Lists.newArrayList();
        for(int i = 1; i < cost.length; i++){
            int sum = cost[i], k = 1;
            while (sum <= v){
                realCost.add(cost[i] * k);
                realWeight.add(weight[i] * k);
                k *= 2;
                sum += cost[i] * k;
            }
        }
        realCost.add(0, 0);
        realWeight.add(0, 0);
        int[] costArray = new int[realCost.size()];
        int[] weightArray = new int[realWeight.size()];
        int sum = 0;
        for(int i = 0; i < realCost.size(); i++){
            costArray[i] = realCost.get(i);
            weightArray[i] = realWeight.get(i);
            sum += costArray[i];
        }
        int[] f = new int[v + 1];
        return pack01(f, costArray, weightArray, v, sum);
    }

    private static int pack01(int[] f, int[] cost, int[] weight, int v, int sum) {
        for (int i = 1; i < cost.length; i++) {
            for (int j = v; j >= Math.max(v - sum, cost[i]); j--) {
                f[j] = Math.max(f[j], f[j - cost[i]] + weight[i]);
            }
            sum -= cost[i];
        }
        return f[v];
    }
}
