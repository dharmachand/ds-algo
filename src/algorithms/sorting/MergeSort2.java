package algorithms.sorting;

import java.util.Arrays;

public class MergeSort2 {
    private static int[] mergeSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;

        int mid = len / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, len));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int m = left.length;
        int n = right.length;
        int[] sorted = new int[m + n];

        int l = 0, r = 0, k = 0;
        while (l < m && r < n) {
            if (left[l] < right[r]) sorted[k++] = left[l++];
            else sorted[k++] = right[r++];
        }

        while (l < m) sorted[k++] = left[l++];
        while (r < n) sorted[k++] = right[r++];

        return sorted;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8, 4, 2};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }
}
