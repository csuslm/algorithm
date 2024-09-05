package scn1.algh.dp;

import java.util.Scanner;

/**
 * 0-1背包问题
 * https://kamacoder.com/problempage.php?pid=1046
 */
public class Bag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cap = sc.nextInt();
        int[][] item = new int[num][2];//0 占用空间 1 价值
        for (int i = 0; i < num; i++) {
            item[i][0] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            item[i][1] = sc.nextInt();
        }
        //dp[i][j] = Math.max(dp[i-1][j],dp[i-1][cap-item[i][0]]+item[i][1]) **定义一定要明确**
        int[][] dp = new int[num][cap+1];
        //初始化
        for (int i = 0; i < item[0][0]; i++) {
            dp[0][i] = 0;
        }
        for (int j = item[0][0]; j <= cap; j++) {
            dp[0][j] = item[0][1];
        }
        for (int i = 0; i < num; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < num; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j < item[i][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i][0]] + item[i][1]);
                }
            }
        }
        System.out.println(dp[num-1][cap]);
    }
}
