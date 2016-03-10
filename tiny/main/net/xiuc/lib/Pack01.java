package net.xiuc.lib;

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

    /**
     * 打印01背包路径
     * print(f, cost, weight, cost.length - 1, v, result); 如果cost从第一个开始存储,
     * 那么打印就从cost.length - 1开始
     * @param f         最大值数组
     * @param cost      物品集合
     * @param weight    价值集合
     * @param i         第i个物品
     * @param j         价值为j
     * @param result    存储01背包路径,物品数组的索引,可以根据这个索引获取到相应的物品
     */
    private static void print(int[] f, int[] cost, int[] weight, int i, int j, List<Integer> result){
        if(j - cost[i] < 0){
            return;
        }
        if(f[j] == f[j - cost[i]] + weight[i]){
            result.add(i);
            print(f, cost, weight, i, j - cost[i], result);
        }else {
            print(f, cost, weight, i - 1, j, result);
        }
    }
}
