package datastructures.arrays;

import datastructures.heaps.MinIntHeap;

import java.util.*;

public class KSmallest {

    private static final Scanner scanner = new Scanner(System.in);

    //Time complexity: O(n pow 2)
    public static Set<Integer> kSmallest(int k, int[] elements) {
        Set<Integer> smallSet = new HashSet<>();
        int small;
        for (int j = 0; j < k; j++) {
            small = elements[0];
            for (int i = 0; i < elements.length; i++) {
                if (!smallSet.contains(elements[i]) && small > elements[i]) {
                    small = elements[i];
                }
            }
            smallSet.add(small);
        }
        return smallSet;
    }


    public static void printElements(Set<Integer> elements) {
        Iterator<Integer> itr = elements.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {

        //7 10 4 3 20 15
        System.out.println("Enter elements: ");
        String[] input = scanner.nextLine().split(" ");

        System.out.println("No. of smallest elements: ");
        int k = Integer.parseInt(scanner.nextLine());

        int[] elements = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            elements[i] = Integer.parseInt(input[i]);
        }

        //Time complexity: O(n pow 2)
        System.out.println("K Smallest elements using 2 loops: ");
        Set<Integer> kSmallElements = kSmallest(k, elements);
        printElements(kSmallElements);

        //Time complexity: O(n + kLogn)
        //Time complexity for building heap is O(n) and
        //Time complexity for each extraction (min element) is O(logn) as it needs to run heapifyDown
        //Time complexity for k extractions is kLogn
        System.out.println("");
        System.out.println("K Smallest elements using min heap: ");
        MinIntHeap minHeap = new MinIntHeap(input.length);
        for (int i = 0; i < input.length; i++) {
            minHeap.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < k; i++) {
            System.out.print(minHeap.extractMin() + " ");
        }

        scanner.close();
    }

}
