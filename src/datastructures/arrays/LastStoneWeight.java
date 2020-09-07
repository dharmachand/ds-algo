package datastructures.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }

    public static int lastStoneWeight1(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        //Expected Output: 1

        System.out.println("Last Stone Weight: " + lastStoneWeight(stones));
        System.out.println("Last Stone Weight: " + lastStoneWeight1(stones));
    }
}
