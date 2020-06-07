package datastructures.arrays;

public class Monotonic {
    public static boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;
        /*
        int i;
        boolean incr = true;
        for (i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                incr = true;
                break;
            } else if (A[i] < A[i + 1]) {
                incr = false;
                break;
            } else { continue; }
        }
        if (i == A.length - 1) return true;
        for (int j = i; j < A.length - 1; j++) {
            if (A[j] == A[j + 1]) { continue; }
            else if (incr && A[j] < A[j + 1]) { return false; }
            else if (!incr && A[j] > A[j + 1]) { return false; }
        }
        return true;
         */

        int i;
        int incr = 0, decr = 0;
        for (i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) { incr++; }
            else if (A[i] < A[i + 1]) { decr++; }
            else {
                incr++;
                decr++;
            }
        }

        if (incr == A.length - 1 || decr == A.length - 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(isMonotonic(nums));
    }
}
