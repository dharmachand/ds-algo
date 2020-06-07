package datastructures.arrays;

import java.util.Arrays;

public class EvenOddParitySort {

    public static int[] sortArrayByParityAuxSpace(int[] A) {
        int len = A.length;
        if (len == 1) return A;

        //space complexity: O(n)
        int[] newA = new int[len];
        int l = 0, r = len - 1;
        for (int i = 0; i < len; i++) {
            if (A[i] % 2 == 0) newA[l++] = A[i];
            else newA[r--] = A[i];
        }

        return newA;
    }

    public static int[] sortArrayByParity(int[] A) {
        int len = A.length;
        if (len == 1) return A;

        // in-pace, space complexity: O(1)
        int l = 0, r = len - 1, temp;
        while (l < r) {
            if (A[l] % 2 > A[r] % 2) {
                temp = A[l];
                A[l] = A[r];
                A[r] = temp;
            }

            if (A[l] % 2 == 0) l++;
            if (A[r] % 2 == 1) r--;
        }

        return A;
    }

    public static int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int even = 0, odd = 1, temp;
        while (even <= len - 2 && odd <= len - 1) {
            if (A[even] % 2 == 1 && A[odd] % 2 == 0) {
                temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }

            if (A[even] % 2 == 0) even += 2;
            if (A[odd] % 2 == 1) odd += 2;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        //Expected Outputs: [4,2,3,1], [2,4,1,3], or [4,2,1,3]
        //int[] nums = {1, 2, 3, 4, 5};
        System.out.println("sortArrayByParityAuxSpace: ");
        System.out.println(Arrays.toString(sortArrayByParityAuxSpace(nums)));

        int[] oNums = {3,1,2,4};
        //Expected Outputs: [4,2,3,1], [2,4,1,3], or [4,2,1,3]
        //int[] oNums = {1, 2, 3, 4, 5};
        System.out.println("sortArrayByParity (In-Place): ");
        System.out.println(Arrays.toString(sortArrayByParity(oNums)));

        int[] o1Nums = {4,2,5,7};
        //Expected Outputs: [4,7,2,5], [2,5,4,7], [2,7,4,5]
        System.out.println("sortArrayByParityII (In-Place): ");
        System.out.println(Arrays.toString(sortArrayByParityII(o1Nums)));
    }
}
