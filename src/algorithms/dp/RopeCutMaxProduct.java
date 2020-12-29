package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class RopeCutMaxProduct {
    /**
     * Given a rope, cut it into parts maximizing the product of their lengths.
     * Example
     * Input: 4
     * Output: 4
     * Length of the rope is 4.
     * All ways it can be cut into parts: 1+3, 1+1+2, 1+1+1+1, 2+2, 2+1+1.
     * Among these, 2+2 cut makes for the greatest product: 2*2=4.
     *
     * Notes
     * Input Parameters: Function has one argument, an integer length of the rope.
     * Output Format: Return an integer, maximum possible product of the given rope’s parts.
     *
     * Constraints:
     * 2 <= length of the rope <= 111
     * You have to cut at least once.
     * Length of the rope, lengths of all parts are all positive integers.
     */

    public static int maxProductRopePieces(int n, Map<Integer, Integer> memo) {
        if (n < 2) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        int maxProduct = 0;
        for (int lhs = 2; lhs < n; lhs++) {
            int rhs = n - lhs;
            int product = lhs * Math.max(rhs, maxProductRopePieces(rhs, memo));
            maxProduct = Math.max(product, maxProduct);
        }
        memo.put(n, maxProduct);
        return maxProduct;
    }

    public static int maxProductRopePiecesDp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int maxProduct = 0;
            for (int lhs = 1; lhs < i; lhs++) {
                int rhs = i - lhs;
                int product = lhs * Math.max(rhs, dp[rhs]);
                product = product % 1000000007; //to avoid integer overflow
                maxProduct = Math.max(maxProduct, product);
            }
            dp[i] = maxProduct;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(maxProductRopePieces(9, new HashMap<>()));
        System.out.println(maxProductRopePiecesDp(9));
    }
}
