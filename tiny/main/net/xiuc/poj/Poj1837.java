package net.xiuc.poj;

import java.util.Scanner;

/**
 * poj1837
 * http://poj.org/showmessage?message_id=170656,看了这个discuss以后才正真的理解思路
 *
 * 思路:dp[i][j]表示把前i个砝码把天平挂成平衡度为j的方案数,其中天平倾角为0时候平衡度为0,第i个砝码可以挂
 * 在m个钩子里面的任何一个,假设挂在第一个那对天平产生的影响就是cs[1]*gs[i] 如果想把天平挂成j,那必须
 * 选择前面i-1个钩子挂成j-cs[1]*gs[i]的那种方案,然后挂上这个钩子,最后才能让天平达到j这个平衡度同样
 * 如果挂在第2个上 那么前面i-1个砝码必须挂成j-cs[2]*gs[i]这个平衡度,挂上这个以后才能达到j 把所有这
 * 些都加起来,就是最后的dp[i][j].....但是j的取值范围比较广泛 是-7500到+7500 所以数组要开大一些
 * Created by 秀川 on 16/2/29.
 */
public class Poj1837 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] c = new int[21];
            int[] w = new int[21];
            for(int i = 1; i <= n; i++){
                c[i] = in.nextInt();
            }
            for(int i = 1; i <= m; i++){
                w[i] = in.nextInt();
            }
            int[][] dp = new int[21][15001];

            dp[0][7500] = 1;

            for(int i = 1; i <= m; i++){
                for(int j = 0; j < 15001; j++){
                    for (int k = 1; k <= n; k++) {
                        if(j > w[i] * c[k] && j - w[i] * c[k] <= 15000){
                            dp[i][j] += dp[i - 1][j - w[i] * c[k]];
                        }
                    }
                }
            }
            System.out.println(dp[m][7500]);
        }
    }
}
