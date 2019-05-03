package datastructures.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddIndexSort {

    private static final Scanner scanner = new Scanner(System.in);

    private static void sortEvenIdxAscOddIdxDesc(int[] elements) {
        int len = elements.length;

        // copy original array in an auxiliary array and sort it
        int[] elementsCopy = Arrays.copyOf(elements, len);
        Arrays.sort(elementsCopy);

        int evenPos = len / 2;
        int oddPos = len - evenPos;


        // fill up odd positions in original array
        // traverse backwards in auxiliary array from j
        int j = oddPos - 1;
        for (int i = 0; i < len; i+=2) {
            elements[i] = elementsCopy[j];
            j--;
        }

        // fill up even positions in original array
        // traverse forwards in auxiliary array from j
        j = oddPos;
        for (int i = 1; i < len; i+=2) {
            elements[i] = elementsCopy[j];
            j++;
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
        System.out.println("");
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Elements after sorting: ");
        sortEvenIdxAscOddIdxDesc(elements);
        printElements(elements);

    }


}
