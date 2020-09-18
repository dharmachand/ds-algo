package algorithms.dp;

public class SubSetSum {
    /**
     * Return true if a subset of the array exists whose sum is equal to given value
     * else return false
     */

    public static boolean hasSubSetSum(int[] nums, int sum) {
        return hasSubSetSum(nums, sum, nums.length - 1, new Boolean[sum + 1]);
    }

    private static boolean hasSubSetSum(int[] nums, int sum, int n, Boolean[] dp) {
        if (sum < 0) return false;
        if (sum == 0) return true;
        if (sum > 0 && n < 1) return false;

        if (dp[sum] != null) return dp[sum];
        return dp[sum] = hasSubSetSum(nums, sum - nums[n], n - 1, dp)
                || hasSubSetSum(nums, sum, n - 1, dp);
    }

    private static boolean hasSubSetSumBottomUp(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,7,8,10};
        int sum = 11;
        //Expected: true

//        int[] nums = {2,7,8,10};
//        int sum = 11;
        //Expected: false

        System.out.println(hasSubSetSum(nums, sum));
        System.out.println(hasSubSetSumBottomUp(nums, sum));
    }
}
