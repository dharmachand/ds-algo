package algorithms.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsBetter {
    /*
    Given a collection of distinct integers, return all possible permutations.

    Example:

    Input: [1,2,3]
    Output:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]

     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, 0, permutations, new ArrayList<>());
        return permutations;
    }

    private static void permute(int[] nums, int start,
                         List<List<Integer>> permutations,
                         List<Integer> permutation) {
        if (start == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            visited.add(nums[i]);

            swap(nums, start, i); //to make unselected permutations consecutive

            permutation.add(nums[start]);
            permute(nums, start + 1, permutations, permutation);
            permutation.remove(permutation.size() - 1);

            swap(nums, start, i); //to unmake selection before it backtracks
        }
    }

    private static void swap(int[] nums, int s, int t) {
        int temp = nums[s];
        nums[s] = nums[t];
        nums[t] = temp;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3};
        //Expected Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        int[] nums = {1, 2, 3, 2};
        //Expected Output:
        System.out.println(permute(nums));
    }

}
