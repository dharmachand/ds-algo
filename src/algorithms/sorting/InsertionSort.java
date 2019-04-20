package algorithms.sorting;

import java.util.Scanner;

public class InsertionSort {

    private static final Scanner scanner = new Scanner(System.in);

    // O(n pow 2)
    public static void insertionSort(int[] elements) {
        int hole, value;
        for (int i = 1; i < elements.length; i++) {
            value = elements[i];
            hole = i;
            while (hole > 0 && elements[hole - 1] > value) {
                elements[hole] = elements[hole - 1];
                hole--;
            }
            elements[hole] = value;
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

        insertionSort(elements);

        System.out.println("Sorted: ");
        printElements(elements);

        scanner.close();
    }

}
