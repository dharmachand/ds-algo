package algorithms.sorting;

import java.util.Scanner;

public class MergeSort {

    private static final Scanner scanner = new Scanner(System.in);

    //Time:-  Worst: O(nlogn) and Space:- O(n)
    public static void mergeSort(int[] elements) {
        int n = elements.length;
        if (n < 2) { return; }
        int mid = n / 2;
        int[] leftElements = new int[mid];
        int[] rightElements = new int[n - mid];
        //copy left elements
        for (int i = 0; i < mid; i++) {
            leftElements[i] = elements[i];
        }
        //copy right elements
        for (int i = mid; i < n; i++) {
            rightElements[i - mid] = elements[i];
        }
        mergeSort(leftElements);
        mergeSort(rightElements);
        merge(leftElements, rightElements, elements);
    }

    private static void merge(int[] leftElements, int[] rightElements, int[] elements) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftElements.length && j < rightElements.length) {
            if (leftElements[i] <= rightElements[j]) {
                elements[k] = leftElements[i];
                i++;
            } else {
                elements[k] = rightElements[j];
                j++;
            }
            k++;
        }
        while (i < leftElements.length) {
            elements[k] = leftElements[i];
            i++;
            k++;
        }
        while (j < rightElements.length) {
            elements[k] = rightElements[j];
            j++;
            k++;
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

        mergeSort(elements);

        System.out.println("Sorted: ");
        printElements(elements);

        scanner.close();
    }

}
