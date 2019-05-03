package algorithms.sorting;

import java.util.Scanner;

public class BubbleSort {

    private static final Scanner scanner = new Scanner(System.in);

    // O(n pow 2)
    public static void bubbleSortAsc(int[] elements) {
        boolean isSorted;
        for (int k = 0; k < elements.length; k++) {
            isSorted = true;
            for (int i = 0; i < elements.length - k - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    swap(elements, i , i + 1);
                    isSorted = false;
                }
            }
            if (isSorted) { break; }
        }
    }

    // O(n pow 2)
    public static void bubbleSortDsc(int[] elements) {
        boolean isSorted;
        for (int k = 0; k < elements.length; k++) {
            isSorted = true;
            for (int i = 0; i < elements.length - k - 1; i++) {
                if (elements[i] < elements[i + 1]) {
                    swap(elements, i , i + 1);
                    isSorted = false;
                }
            }
            if (isSorted) { break; }
        }
    }

    //swap single element
    public static void swap(int[] elements, int aIdx, int bIdx) {
        int temp = elements[aIdx];
        elements[aIdx] = elements[bIdx];
        elements[bIdx] = temp;
    }

    public static void printElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        bubbleSortAsc(elements);
        System.out.println("Sorted ascending: ");
        printElements(elements);

        //reset elements
        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("");

        bubbleSortDsc(elements);
        System.out.println("Sorted descending: ");
        printElements(elements);

        scanner.close();
    }

}
