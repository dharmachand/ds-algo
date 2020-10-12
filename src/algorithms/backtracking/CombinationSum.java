package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
        find all unique combinations in candidates where the candidate numbers sums to target.

        Solution and Similar Problems:
        https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
        https://leetcode.com/problems/permutations/discuss/18284/Backtrack-Summary%3A-General-Solution-for-10-Questions!!!!!!!!-Python-(Combination-Sum-Subsets-Permutation-Palindrome)

     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum(candidates, target, 0, combinations,
                new ArrayList<>());

        return combinations;
    }

    private static void combinationSum(int[] candidates, int target, int start,
                                List<List<Integer>> combinations, List<Integer> combination) {
        if (target < 0) return;

        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i,
                    combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;
        //Expected:[[7], [2,2,3]]

        int[] candidates = {2,3,5};
        int target = 8;
        //Expected: [[2,2,2,2], [2,3,3], [3,5]]

        System.out.println(combinationSum(candidates, target));
    }
}
