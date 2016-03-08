package net.xiuc.poj;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

/**
 * TODO未完成
 * Created by 秀川 on 16/3/8.
 */
public class Poj1276 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int v = in.nextInt();
            int n = in.nextInt();
            int[] cost = new int[n + 1];
            int[] weight = new int[n + 1];
            for(int i = 1;i <= n; i++){
                cost[i] = in.nextInt();
                weight[i] = in.nextInt();
            }
            System.out.println(complete01(cost,weight,v));
        }
    }

    private static int complete01(int[] cost,int[] weight, int v){
        List<Integer> costTemp = Lists.newArrayList();
        List<Integer> weightTemp = Lists.newArrayList();
        for(int b = 1; b < cost.length; b++){
            int c = cost[b];
            int w = weight[b];
            int sc = c,sw = w, k = 1;
            while(sc < v){
                costTemp.add(sc);
                weightTemp.add(sw);
                k <<= 1;
                sc += c * k;
                sw += w * k;
            }
        }
        Integer[] costAll = new Integer[costTemp.size()];
        Integer[] weightAll = new Integer[weightTemp.size()];
        costTemp.toArray(costAll);
        weightTemp.toArray(weightAll);

        int sum = 0;
        for(Integer c: costAll){
            sum += c;
        }
        int[] f = new int[v + 1];
        for (int i = 1; i < costAll.length; i++) {
            for (int j = v; j >= Math.max(v - sum, costAll[i]); j--) {
                f[j] = Math.max(f[j], f[j - costAll[i]] + weightAll[i]);
            }
            sum -= costAll[i];
        }
        return f[v];
    }
}
