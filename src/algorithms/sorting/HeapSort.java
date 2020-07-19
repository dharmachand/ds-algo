package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    private static final Scanner scanner = new Scanner(System.in);

    public static void heapSort(int[] nums) {
        int n = nums.length;
        // Build max heap - rearrange array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Move max element to last
            swap(nums, 0, i);

            // Call max heapify on reduced heap to exclude sorted (max) elements
            heapify(nums, i, 0);
        }
    }

    // heapify down on Max Heap
    private static void heapify(int[] nums, int n, int curr) {
        int max = curr;
        int left = 2 * curr + 1;
        int right = 2 * curr + 2;

        // Compare curr with left and right and find max
        if (left < n && nums[left] > nums[max]) max = left;
        if (right < n && nums[right] > nums[max]) max = right;

        if (max != curr) {
            // Move max element up the tree
            swap(nums, max, curr);
            // Repeat until leaf level
            heapify(nums, n, max);
        }
    }

    private static void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    public static void main(String[] args) {
        /*
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");
        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }
        */

        //int[] elements = {6, 2, 8, 9, 7, 10, 15, 20, 13};
        int[] elements = {4, 10, 3, 5, 1, 12, 0, 15};
        System.out.println(Arrays.toString(elements));

        heapSort(elements);

        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(elements));

        //scanner.close();
    }

}
