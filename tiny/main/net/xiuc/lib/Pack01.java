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
     * @param cost      花费
     * @param weight    价值
     * @param v         总容量
     * @param sum       所有花费总和
     * @return          最大价值
     */
    private static int pack01(int[] cost,int[] weight, int v, int sum){
        int[] f = new int[v + 1];
        for (int i = 1; i < cost.length; i++) {
            for (int j = v; j >= Math.max(v - sum, cost[i]); j--) {
                f[j] = Math.max(f[j], f[j - cost[i]] + weight[i]);
            }
            sum -= cost[i];
        }
        return f[v];
    }

    private static int pack011(int[] cost, int[] weight, int v, int sum){
        int[][] f = new int[cost.length][v + 1];
        for(int i = 1; i < cost.length; i++){
            for(int j = v; j >= Math.max(f[i][j],f[i - 1][j - cost[i]] + weight[i]); j--){
                f[i][j] = Math.max(f[i][j], f[i - 1][j - cost[i]] + weight[i]);
            }
            sum -= cost[i];
        }
        List<Integer> result = Lists.newArrayList();
        print011(f, cost, weight, cost.length - 1, v, result);
        for(Integer choose : result){
            System.out.print(choose + ",");
        }
        return f[cost.length - 1][v];
    }

    private static void print011(int[][] f, int[] cost, int[] weight, int i, int j, List<Integer> result){
        if(i < 1 || j < cost[i]){
            return;
        }
        if(f[i][j] == f[i - 1][j - cost[i]] + weight[i]){
            result.add(i);
            print011(f, cost, weight, i - 1, j - cost[i], result);
        }else {
            print011(f, cost, weight, i - 1, j, result);
        }
    }
}
