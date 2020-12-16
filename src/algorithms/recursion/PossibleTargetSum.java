package algorithms.recursion;

public class PossibleTargetSum {
    /*
     * Complete the function below.
     */
    static boolean check_if_sum_possible(long[] arr, long k) {
        return checkifSumPossible(arr, 0, k, 0);
    }

    private static boolean checkifSumPossible(long[] arr, int pos, long k, long partial) {
        if (pos == arr.length) {
            if (k == partial) return true;
            return false;
        } else {
            if (pos == arr.length) return false;

            boolean b1 = checkifSumPossible(arr, pos + 1, k, partial); //exclude
            boolean b2 = checkifSumPossible(arr, pos + 1, k, partial + arr[pos]); //include

            return b1 || b2;
        }
    }

    public static void main(String[] args) {
        //long[] nums = {-10, 10};
        //long target = 0;
        long[] nums = {-2, 2, 1, 2, 3};
        long target = 0;
        System.out.println(check_if_sum_possible(nums, target));
    }
}
