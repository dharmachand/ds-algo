package datastructures.arrays;

import java.util.*;

public class FourSumBest {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }



    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //Expected Output:

        //int[] nums = {-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1};
        //Expected Output:

        int target = 0;
        int[] nums = {1, 0, -1, 0, -2, 2};
        //Expected Output: [[-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2]]

        long startTime = System.nanoTime();
        String result = fourSum(nums, target).toString();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; //milli secs
        System.out.println(result);
        System.out.println("ExecTime: " + duration);
    }
}
