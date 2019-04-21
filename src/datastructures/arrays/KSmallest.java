package datastructures.arrays;

import java.util.*;

public class KSmallest {

    private static final Scanner scanner = new Scanner(System.in);

    public static Set<Integer> kSmallest(int k, int[] elements) {
        Set<Integer> smallSet = new HashSet<>();
        int small;
        int smallSum = 0;
        for (int j = 0; j < k; j++) {
            small = elements[0];
            for (int i = 0; i < elements.length; i++) {
                if (!smallSet.contains(elements[i]) && small > elements[i]) {
                    small = elements[i];
                }
            }
            smallSet.add(small);
            smallSum = smallSum + small;
        }
        System.out.println("smallSum: " + smallSum);
        return smallSet;
    }


    public static void printElements(Set<Integer> elements) {
        Iterator<Integer> itr = elements.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {

        System.out.println("No. of smallest elements: ");
        int k = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter elements: ");
        String[] input = scanner.nextLine().split(" ");

        int[] elements = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            elements[i] = Integer.parseInt(input[i]);
        }

        Set<Integer> kSmallElements = kSmallest(k, elements);

        System.out.println("K Smallest elements: ");
        printElements(kSmallElements);

        scanner.close();
    }

}
