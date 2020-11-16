package datastructures.arrays;

import java.util.Arrays;

public class MergeKSortedArrrays {
    /*
     * Complete the mergeArrays function below.
     */
    static int[] mergeArrays(int[][] arr) {
        int k = arr.length;
        if (k == 0) return new int[1];
        int n = arr[0].length;
        int[] mergedArrays = new int[n * k];

        boolean reverseSorted = isReverseSorted(arr);
        int minOrMax, minOrMaxIdx = 0, l = 0, curr;
        int[] indices = new int[k];
        while (!isAllExhausted(indices, n)) {
            minOrMax = reverseSorted ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                curr = indices[i];
                if (curr == n) continue;
                if ((reverseSorted && minOrMax < arr[i][curr])
                    || (!reverseSorted && minOrMax > arr[i][curr])) {
                    minOrMax = arr[i][curr];
                    minOrMaxIdx = i;
                }
            }
            mergedArrays[l++] = minOrMax;
            indices[minOrMaxIdx]++;
        }

        return mergedArrays;
    }

    static boolean isAllExhausted(int[] indices, int n) {
        for (int idx : indices) {
            if (idx < n) return false;
        }
        return true;
    }

    static boolean isReverseSorted(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] > arr[i][j + 1]) return true;
                else if (arr[i][j] < arr[i][j + 1]) return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 3, 5, 7},
//                        {2, 4, 6, 8},
//                        {0, 9, 10, 11}};
        //Expected Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

        int[][] arr = {{8, 8, 8, 8, 8},
                {8, 8, 8, 8, 8},
                {8, 8, 8, 8, 7},
                {8, 8, 8, 8, 8},
                {8, 8, 8, 8, 8}};
        //Expected Output: [8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7]

        System.out.println(Arrays.toString(mergeArrays(arr)));
    }
}
