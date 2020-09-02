package datastructures.arrays.dp;

import java.util.Arrays;

public class CoinChange {
    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     */

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
           for (int j = 0; j < coins.length; j++) {
               if (coins[j] > i) break;
               dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
           }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChangeRecursive(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChangeRecursive(coins, amount, new int[amount]);
    }

    private static int coinChangeRecursive(int[] coins, int amount, int[] dp) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (dp[amount - 1] != 0) return dp[amount - 1];

        int min = Integer.MAX_VALUE, result;
        for (int coin : coins) {
            result = coinChangeRecursive(coins, amount - coin, dp);
            if (result >= 0 && result < min) min = result + 1;
        }
        return dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        //Expected: 3

        int[] coins = {2};
        int amount = 3;
        //Expected: -1

//        int[] coins = {25, 10, 5};
//        int amount = 30;
        //Expected: 2

//        int[] coins = {9, 6, 5, 1};
//        int amount = 11;
        //Expected: 2

//        int[] coins = {186,419,83,408};
//        int amount = 6249;
        //Expected: 20

//        int[] coins = {1,2,5};
//        int amount = 100;
        //Expected: 20

//        int[] coins = {2,5,10,1};
//        int amount = 27;
        //Expected: 4

        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeRecursive(coins, amount));

    }


}
