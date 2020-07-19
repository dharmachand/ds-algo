package datastructures.arrays;

import java.util.Arrays;

public class LastStoneWeight {
    public static int lastStoneWeightLinear(int[] stones) {
        int[] sortedStones = new int[1001];

        for (int stone : stones) {
            sortedStones[stone] += 1;
        }

        int x, y, i = 1000;
        while (i > 0) {
            while (i > 0 && sortedStones[i] == 0) {
                i--;
            }
            while (i > 0 && sortedStones[i] > 1) {
                sortedStones[i] -= 2;
            }
            if (i < 2) return i; //TODO: Fix logic here
            y = i;
            i--;
            while (i > 0 && sortedStones[i] == 0) {
                i--;
            }
            x = i;
            if (sortedStones[i] == 1) i--;
            if (y - x > 0) {
                sortedStones[y - x] += 1;
            }
            sortedStones[x] -= 1;
            sortedStones[y] -= 1;
        }

        return i;
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        //Expected Output: 1

        System.out.println("Last Stone Weight: " + lastStoneWeight(stones));
    }
}
