package datastructures.arrays.dp;

public class CoinChange2 {
    /**
     * You are given coins of different denominations and a total amount of money.
     * Write a function to compute the number of combinations that make up that amount.
     * You may assume that you have infinite number of each kind of coin.
     */

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + (j - coins[i - 1] < 0 ? 0 : dp[i][j - coins[i - 1]]);
            }
        }
        return dp[coins.length][amount];
    }

    private static int changeRecursive(int amount, int[] coins, int m) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (m <= 0 && amount >= 1) return 0;

        return changeRecursive(amount, coins, m - 1) + changeRecursive(amount - coins[m - 1], coins, m);
    }

    public static int changeRecursive(int amount, int[] coins) {
        return changeRecursive(amount, coins, coins.length);
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        //Expected: 4

//        int[] coins = {2};
//        int amount = 3;
        //Expected: 0

//        int[] coins = {10};
//        int amount = 10;
        //Expected: 1

//        int[] coins = {9, 6, 5, 1};
//        int amount = 11;
        //Expected: 6

//        int[] coins = {186,419,83,408};
//        int amount = 6249;
        //Expected: 19

        System.out.println(change(amount, coins));
        System.out.println(changeRecursive(amount, coins));

    }

}
