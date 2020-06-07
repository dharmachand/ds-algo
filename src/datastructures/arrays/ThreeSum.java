package datastructures.arrays;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int sum, low, high;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || (i > 0 && nums[i] != nums[i - 1])) {
                sum = -nums[i];
                low = i + 1;
                high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) high--;
                    else low++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //Expected Output: [[-1,-1,2],[-1,0,1]]

        //int[] nums = {-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1};
        //Expected Output: [[-2,-1,3],[-2,1,1],[-1,0,1],[0,0,0]]

        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        //Expected Output: [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]

        //int[] nums = {0,8,2,-9,-14,5,2,-5,-5,-9,-1,3,1,-8,0,-3,-12,2,11,9,13,-14,2,-15,4,10,9,7,14,-8,-2,-1,-15,-15,-2,8,-3,7,-12,8,6,2,-12,-8,1,-4,-3,5,13,-7,-1,11,-13,8,4,6,3,-2,-2,3,-2,3,9,-10,-4,-8,14,8,7,9,1,-2,-3,5,5,5,8,9,-5,6,-12,1,-5,12,-6,14,3,5,-11,8,-7,2,-12,9,8,-1,9,-1,-7,1,-7,1,14,-3,13,-4,-12,6,-9,-10,-10,-14,7,0,13,8,-9,1,-2,-5,-14};

        System.out.println("==========Input===============");
        System.out.println(Arrays.toString(nums));
        System.out.println("==============================");

        List<List<Integer>> tripletList = ThreeSum.threeSum(nums);

        System.out.println("==========Output===============");
        System.out.println(tripletList);
    }

}
