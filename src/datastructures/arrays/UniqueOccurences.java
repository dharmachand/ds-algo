package datastructures.arrays;

import java.util.*;

/**
 *Given an array of integers arr, write a function that returns true if and only if
 * the number of occurrences of each value in the array is unique.
 */
public class UniqueOccurences {
    public static boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int i = 1, count = 1;
        Set<Integer> counts = new HashSet<>();
        while (i < arr.length) {
            if (arr[i] == arr[i - 1]) {
                i++;
                count++;
            } else {
                if (!counts.add(count)) return false;
                count = 1;
                i++;
            }
        }
        if (counts.contains(count)) return false;
        return true;
    }

    public static boolean uniqueOccurrences1(int[] arr) {
        int[] numFreq = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            numFreq[arr[i] + 1000]++;
        }

        Set<Integer> freqs = new HashSet<>();
        for (int i = 0; i < numFreq.length; i++) {
            if (numFreq[i] == 0) continue;
            if (freqs.contains(numFreq[i])) return false;
            else freqs.add(numFreq[i]);
        }
        return true;
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numFreq.put(arr[i], numFreq.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> freqs = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            if (freqs.contains(entry.getValue())) return false;
            else freqs.add(entry.getValue());
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(nums));
    }
}
