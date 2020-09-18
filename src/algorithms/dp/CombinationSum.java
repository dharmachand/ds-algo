package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.
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
