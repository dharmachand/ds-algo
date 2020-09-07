package datastructures.arrays.dp;

public class TargetSum {
    /**
     You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
     Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

     Find out how many ways to assign symbols to make sum of integers equal to target S.
     */

    public static int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0, 0, new Integer[nums.length][2001]);
    }

    private static int findTargetSumWays(int[] nums, int S, int sum, int i, Integer[][] dp) {
        if (i >= nums.length) {
            if (sum == S)  return 1;
            else return 0;
        }

        if (dp[i][sum + 1000] != null) return dp[i][sum + 1000];

        return dp[i][sum + 1000] = findTargetSumWays(nums, S, sum + nums[i], i + 1, dp)
                + findTargetSumWays(nums, S, sum - nums[i], i + 1, dp);
    }

    public static int findTargetSumWaysBottomUp(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] +=  dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] +=  dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int sum = 3;
        //Expected: 5

        System.out.println(findTargetSumWays(nums, sum));
        System.out.println(findTargetSumWaysBottomUp(nums, sum));
    }
}
