package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    /*
        Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
        You may return the answer in any order.

        Input: n = 4, k = 2
        Output:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        combine(n, k, 1, combinations, new ArrayList<>());

        return combinations;
    }

    private static void combine(int n, int k, int start,
                         List<List<Integer>> combinations,
                         List<Integer> combination) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            combine(n, k - 1, i + 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }

    //Efficient Solution
    // C(n, k) = C(n - 1, k - 1) + C(n - 1, k)
    public static List<List<Integer>> combine2(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine2(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine2(n - 1, k));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine2(4, 2));
    }

}
