package scn1.algh.dp;

import java.util.Arrays;

public class Topics {
    public static boolean depart(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1){
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
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5};
        depart(nums);
    }
}
