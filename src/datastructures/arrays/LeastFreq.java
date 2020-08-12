package datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Least frequent elements in an array
 */
public class LeastFreq {
    public static long[] findLeastFreqNumbers(long[] numbers) {
        Map<Long, Integer> numFreq = new HashMap<>();
        for (long num : numbers) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE, minFreqCount = 0;
        for(Map.Entry<Long, Integer> entry : numFreq.entrySet()) {
            if (minFreq > entry.getValue()) minFreq = entry.getValue();
        }
        for(Map.Entry<Long, Integer> entry : numFreq.entrySet()) {
            if (entry.getValue() == minFreq) minFreqCount++;
        }

        long[] result = new long[minFreqCount];
        int i = 0;
        for(Map.Entry<Long, Integer> entry : numFreq.entrySet()) {
            if (entry.getValue() == minFreq) result[i++] = entry.getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 2, 1, 2, 2, 3, 1, 0, 0};
        System.out.println(Arrays.toString(findLeastFreqNumbers(arr)));
    }
}
