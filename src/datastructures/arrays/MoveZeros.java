package datastructures.arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int temp, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
        /*
        int temp, i = 0, len = nums.length, zeroIdx = 0, nonZeroIdx = 0;
        while (i < len) {
            while (i < len && nums[i] != 0) i++;
            zeroIdx = i;
            while (i < len && nums[i] == 0) i++;
            nonZeroIdx = i;

            if (i < len && zeroIdx < nonZeroIdx) {
                temp = nums[zeroIdx];
                nums[zeroIdx] = nums[nonZeroIdx];
                nums[nonZeroIdx] = temp;

                i = zeroIdx;
            }
        }
        */
    }

    public static void main(String[] args) {
        int[] inp = {0,1,0,3,12};

        moveZeroes(inp);

        System.out.println(Arrays.toString(inp));

     }
}
