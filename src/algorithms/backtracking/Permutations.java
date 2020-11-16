package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
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

     Solution and Similar Problems:
        https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
        https://leetcode.com/problems/permutations/discuss/18284/Backtrack-Summary%3A-General-Solution-for-10-Questions!!!!!!!!-Python-(Combination-Sum-Subsets-Permutation-Palindrome)
     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, permutations, new ArrayList<>());
        return permutations;
    }

    private static void permute(int[] nums,
                         List<List<Integer>> permutations,
                         List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //Time Complexity is O(n) which can be done in O(1) and also can't handle duplicates
            //Refer PermutationsBetter
            if (permutation.contains(nums[i])) continue;
            permutation.add(nums[i]);
            permute(nums, permutations, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

}
