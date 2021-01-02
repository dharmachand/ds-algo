package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EqualPartitionSumII {
    /**
     * Equal Sub Set Partition
     *
     *
     *
     * Given an array s of n integers, partition it into two non-empty subsets, s1 and s2, such that the sum of all elements in s1 is equal to the sum of all elements in s2. Return a boolean array of size n where i-th element is True if i-th element of s belongs to s1 and False if it belongs to s2. Any valid answer will be accepted. If such partitioning is not possible, return an empty array.
     *
     *
     *
     * Example
     *
     * Input: n = 6, s = [10, -3, 7, 2, 1, 3]
     *
     * Output: [True, True, False, False, False, True]
     *
     *
     *
     * There are multiple partitionings where s1 sums up to 10 and s2 sums up to 10; they are all correct answers:
     *
     * s1 = [ 10 , -3 , 3 ] and s2 = [ 7 , 2 , 1 ] (Sample output)
     * s1 = [ 7 , 2 , 1 ] and s2 = [ 10 , -3 , 3 ]
     * s1 = [10] and s2 = [-3, 3, 7, 2, 1]
     * s1 = [-3, 3, 7, 2, 1] and s2 = [10]
     * s1 = [10, -3, 2, 1] and s2 = [7, 3]
     * s1 = [7, 3] and s2 = [10, -3, 2, 1]
     *
     *
     * Notes
     *
     * Input Parameters: The first and only parameter of the function that is to be implemented is the array of integers s, that is to be partitioned.
     *
     *
     *
     * Output Format: If it is possible to partition the given array s in an above-said manner then return a boolean array of size n, where its i (0<=i<N) element is true if it is the part of s1 else false if it is the part of s2. In case it is not possible to partition the array s, then return an empty array.
     *
     *
     *
     * Constraints:
     *
     * 1 <= n <= 100
     * -100 <= elements in s <= 100
     */

    public static List<Boolean> equalSubSetSumPartition(List<Integer> s) {
        List<Boolean> result = new ArrayList<>();
        int tSum = 0, posSum = 0, negSum = 0;
        for (int num : s) {
            if (num > 0) posSum += num;
            else negSum += num;
        }
        tSum = posSum + negSum;
        if (tSum % 2 != 0) return result;
        int range = posSum - negSum;

        int len = s.size();
        int halfSum = tSum / 2;
        boolean[][] dp = new boolean[len][range + 1];

        dp[0][s.get(0) - negSum] = true;

        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= range; j++) {
                // exclude current element
                dp[i][j] = dp[i - 1][j];

                // include current element
                if (j + negSum == s.get(i))
                    dp[i][j] = true;
                else if (0 <= j - s.get(i) && j - s.get(i) <= range ) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - s.get(i)];
                }
            }
        }

        // check if it possible to partition
        if (!dp[len - 1][halfSum - negSum]) return result;

        // it is possible, so collect the elements now
        result = new ArrayList<Boolean>(Arrays.asList(new Boolean[len]));
        Collections.fill(result, Boolean.FALSE);
        int count = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (i > 0) {
                if (dp[i][halfSum - negSum] && !dp[i - 1][halfSum - negSum]) {
                    result.set(i, Boolean.TRUE);
                    count++;
                    halfSum -= s.get(i);
                    if (halfSum == 0) {
                        break;
                    }
                }
            } else {
                result.set(i, Boolean.TRUE);
                count ++;
            }
        }
        if (count == 0 || count == len) {
            return new ArrayList<Boolean>();
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] input = {10, -3, 7, 2, 1, 3};
        System.out.println(equalSubSetSumPartition(Arrays.asList(input.clone())));
    }
}
