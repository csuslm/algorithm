package scn1.algh.dp;

import java.util.Arrays;

public class Topics {
    public static boolean depart(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int[][] dp = new int[nums.length][sum / 2 + 1];
        dp[0][0] = 0;
        for (int i = nums[0]; i < (sum / 2 + 1); i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < (sum / 2 + 1); j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < sum / 2 + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return dp[nums.length - 1][sum / 2] == sum / 2;
    }

    /**
     * https://leetcode.cn/problems/last-stone-weight-ii/
     */
    public int lastStoneWeightII(int[] stones) {

        return 0;
    }

    public static int countUp(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            char c = text1.charAt(i);
            for (int j = 0; j < n; j++) {
                char c1 = text2.charAt(j);
                if (c == c1) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 交错字符串 mid
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        if (s3.isEmpty()) {
            return true;
        }
        if (m == 0) {
            return s2.equals(s3);
        }
        if (n == 0) {
            return s1.equals(s3);
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int index = i + j - 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (s2.charAt(j - 1) == s3.charAt(index)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) == s3.charAt(index)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (s1.charAt(i - 1) == s3.charAt(index)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (s2.charAt(j - 1) == s3.charAt(index)) {
                        dp[i][j] |= dp[i][j - 1];//按位或
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * https://leetcode.cn/problems/21dk04/ hard
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    /**
     * TODO 零钱兑换
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5};
        depart(nums);
    }
}
