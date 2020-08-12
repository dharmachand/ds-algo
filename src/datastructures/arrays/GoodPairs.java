package datastructures.arrays;

public class GoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int[] numCounts = new int[101];
        for (int num : nums) {
            numCounts[num]++;
        }

        int count = 0, pairs = 0;
        for (int numCount: numCounts) {
            // formula for combinations of 2 from n is n * (n - 1) / 2
            if (numCount > 1)
                pairs = numCount * (numCount - 1) / 2;
            count += pairs;
            pairs = 0;
        }

        return count;
    }
    public static int numIdenticalPairsOptimized(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(numIdenticalPairs(nums));
        System.out.println(numIdenticalPairsOptimized(nums));
    }
}
