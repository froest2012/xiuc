package net.xiuc.lib;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 01背包库
 * Created by 秀川 on 16/3/11.
 */
public class Pack01 {
    /**
     * 01背包,cost和weight都需要开大一位数组,都是从1开始计数的
     *
     * @param f      一维状态数组,多开大一位
     * @param cost   花费,多开大一位,从1开始
     * @param weight 价值
     * @param v      总容量
     * @param sum    所有花费总和
     *
     * @return 最大价值
     */
    private static int pack01(int[] f, int[] cost, int[] weight, int v, int sum) {
        for (int i = 1; i < cost.length; i++) {
            for (int j = v; j >= Math.max(v - sum, cost[i]); j--) {
                f[j] = Math.max(f[j], f[j - cost[i]] + weight[i]);
            }
            sum -= cost[i];
        }
        return f[v];
    }

    /**
     * 二维数组存储状态
     *
     * @param f      二维数组存储状态,多开大一位
     * @param cost   费用,多开大一位,从1开始
     * @param weight 价值
     * @param v      总容量
     *
     * @return 最大价值
     */
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

    /**
     * 完全背包二进制解法
     *
     * @param cost      费用数组
     * @param weight    价值数组
     * @param v         背包容量
     * @return          最大价值
     */
    private static int completePack011binary(int[] cost, int[] weight, int v){
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
        return pack011(f, costArray, weightArray, v);
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
}
