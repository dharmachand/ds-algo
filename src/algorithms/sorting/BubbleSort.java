package algorithms.sorting;

import java.util.Scanner;

public class BubbleSort {

    private static final Scanner scanner = new Scanner(System.in);

    // O(n pow 2)
    public static void bubbleSort(int[] elements) {
        int temp;
        boolean isSorted;
        for (int k = 0; k < elements.length; k++) {
            isSorted = true;
            for (int i = 0; i < elements.length - k - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;

                    isSorted = false;
                }
            }
            if (isSorted) { break; }
        }
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

        bubbleSort(elements);

        System.out.println("Sorted: ");
        printElements(elements);

        scanner.close();
    }

}
