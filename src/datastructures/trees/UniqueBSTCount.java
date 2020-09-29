package datastructures.trees;

import java.util.HashMap;
import java.util.Map;

public class UniqueBSTCount {
    /*
        Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
        Input: 3
        Output: 5
        Explanation:
        Given n = 3, there are a total of 5 unique BST's:

           1         3     3      2      1
            \       /     /      / \      \
             3     2     1      1   3      2
            /     /       \                 \
           2     1         2                 3

       Solution:
       https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
       F(i, n) = G(i-1) * G(n-i)
     */

    public static int numTreesIterative(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        return numTrees(n, map);
    }

    private static int numTrees(int n, Map<Integer, Integer> map) {
        // check memory
        if(map.containsKey(n)) return map.get(n);
        // recursion
        int sum = 0;
        for(int i = 1; i <= n; i++)
            sum += numTrees(i - 1, map) * numTrees(n - i, map);
        map.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numTreesIterative(3));
        System.out.println(numTrees(3));
    }
}
