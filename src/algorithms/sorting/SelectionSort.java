package algorithms.sorting;

import java.util.Scanner;

public class SelectionSort {

    private static final Scanner scanner = new Scanner(System.in);

    // O(n pow 2)
    public static void selectionSort(int[] elements) {
        int temp, iMin;
        for (int i = 0; i < elements.length - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[iMin]) {
                    iMin = j;
                }
            }
            temp = elements[i];
            elements[i] = elements[iMin];
            elements[iMin] = temp;
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

        selectionSort(elements);

        System.out.println("Sorted: ");
        printElements(elements);

        scanner.close();
    }

}
