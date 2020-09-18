package algorithms.dp;

public class LastStoneWeightII {

    /** Solution:-
     This question equals to partition an array into 2 subsets whose difference is minimal
     (1) S1 + S2  = S
     (2) S1 - S2 = diff

     ==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2

     Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this

     dp[i][j]   = {true if some subset from 1st to j'th has a sum equal to sum i, false otherwise}
     i ranges from (sum of all elements) {1..n}
     j ranges from  {1..n}

     same as 494. Target Sum
     */

    public static int lastStoneWeightII(int[] stones) {
        int s = 0, s2 = 0;
        for (int stone : stones) s += stone;

        int n = stones.length;
        boolean[][] dp = new boolean[s + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s / 2; j++) {
                if (dp[j][i - 1] || (j >= stones[i - 1] && dp[j - stones[i - 1]][i - 1])) {
                    dp[j][i] = true;
                    s2 = Math.max(s2, j);
                }
            }
        }

        return s - 2 * s2;
    }


    public static int lastStoneWeightIIRecursive(int[] stones) {
        int sum = 0;
        for(int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        Integer[][] dp =  new Integer[stones.length][sum + 1];
        return lastStoneWeightIIRecursive(dp, 0, 0, 0, stones);
    }

    private static int lastStoneWeightIIRecursive(Integer[][] dp, int sum1, int sum2, int i, int[] stones) {
        if (i >= stones.length) return Math.abs(sum1 - sum2);

        if (dp[i][Math.abs(sum1 - sum2)] != null) return dp[i][Math.abs(sum1 - sum2)];

        return dp[i][Math.abs(sum1 - sum2)] =
                Math.min(lastStoneWeightIIRecursive(dp, sum1 + stones[i], sum2, i + 1, stones),
                        lastStoneWeightIIRecursive(dp, sum1, sum2 + stones[i], i + 1, stones));
    }

    public static void main(String[] args) {
        //int[] stones = {2,7,4,1,8,1};
        //Expected Output: 1

        //int[] stones = {3,3,1,1,1};
        //Expected Output: 1

        //int[] stones = {1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98};
        //Expected Output: 1

        int[] stones = {1,1,1,1,1};
        //Expected Output: 1

        System.out.println(lastStoneWeightII(stones));
        System.out.println(lastStoneWeightIIRecursive(stones));
    }
}
