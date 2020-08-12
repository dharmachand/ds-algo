package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class Stairs {
    /*
    A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps
    at a time. Implement a method to count how many possible ways the child can run up the stairs.
     */

    // A recursive function used by countWays
    public static long countWays(int n)
    {
        long[] res = new long[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2]
                    + res[i - 3];

        return res[n];
    }

    // Driver function
    public static void main(String argc[])
    {
        int n = 5;
        System.out.println(countWays(n));

        String s = "ssddfffffc";
        Map charCount = new HashMap();
        for (char c : s.toCharArray()) {
            charCount.put(c, (int)charCount.getOrDefault(c, 0) + 1);
        }
        charCount.keySet().size();
    }
}
