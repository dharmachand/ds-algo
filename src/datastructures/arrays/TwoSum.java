package datastructures.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        //a + b = target
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                result.add(Arrays.asList(nums[low], nums[high]));
                while(low < high && nums[low] == nums[low + 1]) low++;
                while(low < high && nums[high] == nums[high - 1]) high--;
                low++;
                high--;
            } else if (nums[low] + nums[high] > target) high--;
            else low++;
        }
        return result;
    }


    public static void main(String[] args) {
        //int target = 1;
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //Expected Output: [[0,1],[2,-1]]

        int target = 2;
        int[] nums = {-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1};
        //Expected Output: [[-1, 3], [1, 1]]

        //int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        //Expected Output:

        long startTime = System.nanoTime();
        String result = twoSum(nums, target).toString();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; //milli secs
        System.out.println(result);
        System.out.println("ExecTime: " + duration);

    }

}
