package algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    /*
    Find all possible combinations of k numbers that add up to a number n,
    given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     */

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        combinationSum3(k, n, 1, combinations, combination);

        return combinations;
    }

    private static void combinationSum3(int k, int n, int start,
                                 List<List<Integer>> combinations,
                                 List<Integer> combination) {
        if (combination.size() == k && n == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if (combination.size() == k || n < 0) return;

        for (int i = start; i <= 9; i++) {
            combination.add(i);
            combinationSum3(k, n - i, i + 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int k = 3;
//        int n = 7;
        //Expected: [[1,2,4]]

        int k = 3;
        int n = 9;
        //Expected: [[1,2,6], [1,3,5], [2,3,4]]

        System.out.println(combinationSum3(k, n));
    }
}
