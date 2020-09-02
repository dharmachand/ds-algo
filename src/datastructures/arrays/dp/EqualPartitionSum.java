package datastructures.arrays.dp;

public class EqualPartitionSum {
    /**
     *  Given a non-empty array containing only positive integers,
     *  find if the array can be partitioned into two subsets such that the sum of elements
     *  in both subsets is equal.
     */

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        return canPartition(nums, sum / 2, nums.length - 1, new Boolean[sum + 1]);
    }

    private static boolean canPartition(int[] nums, int sum, int n, Boolean[] dp) {
        if (sum < 0) return false;
        if (sum == 0) return true;
        if (sum > 0 && n < 0) return false;

        if (dp[sum] != null) return dp[sum];
        return dp[sum] = canPartition(nums, sum - nums[n], n - 1, dp)
                || canPartition(nums, sum, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        //Expected: true

        //int[] nums = {1, 2, 3, 5};
        //Expected: false

        //int[] nums = {23,13,11,7,6,5,5};
        //Expected: true

        System.out.println(canPartition(nums));

    }
}
