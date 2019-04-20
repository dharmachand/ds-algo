package algorithms.sorting;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private static final Scanner scanner = new Scanner(System.in);

    // Best: O(nlogn). Worst: O(n pow 2)
    public static void quickSort(int[] elements, int start, int end) {
        if (start >= end) { return; }
        int pIndex = randomizedPartition(elements, start, end);
        quickSort(elements, start, pIndex - 1);
        quickSort(elements, pIndex + 1, end);
    }

    private static int partition(int[] elements, int start, int end) {
        int pivot = elements[end];
        int pIndex = start;
        int temp;
        for (int i = start; i < end; i++) {
            if (elements[i] <= pivot) {
                temp = elements[i];
                elements[i] = elements[pIndex];
                elements[pIndex] = temp;
                pIndex++;
            }
        }
        temp = elements[pIndex];
        elements[pIndex] = elements[end];
        elements[end] = temp;

        return pIndex;
    }

    //to avoid worst case scenario of time complexity:  O(n pow 2)
    private static int randomizedPartition(int[] elements, int start, int end) {
        Random r = new Random();
        int pivotIndex = r.nextInt(end - start) + start;
        int temp = elements[pivotIndex];
        elements[pivotIndex] = elements[end];
        elements[end] = temp;
        return partition(elements, start, end);
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

        quickSort(elements, 0, elements.length - 1);

        System.out.println("Sorted: ");
        printElements(elements);

        scanner.close();
    }

}
