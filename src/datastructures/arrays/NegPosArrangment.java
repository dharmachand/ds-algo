package datastructures.arrays;

import java.util.Scanner;

public class NegPosArrangment {

    private static final Scanner scanner = new Scanner(System.in);

    //arrange -ve and +ve numbers alternatively
    private static void arrangeNegaPosAlternatively(int[] elements) {
        int len = elements.length;
        int pivot = 0, pIndex = 0, i;
        for (i = 0; i < len; i++) {
            if (elements[i] < pivot) {
                swap(elements, i, pIndex);
                pIndex++;
            }
        }

        i = 0;
        while (i < pIndex && pIndex < len && elements[i] < 0) {
            swap(elements, i, pIndex);
            i += 2;
            pIndex += 2;
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

        //-1 2 -3 4 5 6 -7 8 9
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Elements after sorting: ");
        arrangeNegaPosAlternatively(elements);
        printElements(elements);

    }


}
