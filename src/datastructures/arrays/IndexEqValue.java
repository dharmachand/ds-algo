package datastructures.arrays;

import java.util.HashSet;
import java.util.Scanner;

public class IndexEqValue {

    private static final Scanner scanner = new Scanner(System.in);

    //swap elements to right place if its not there
    private static int[] rearrangeElementsToMatchIndexAndValue2(int[] elements) {
        for (int i = 0; i < elements.length;) {
            if (elements[i] != -1 && elements[i] != i) {
                swap(elements, i, elements[i]);
            } else {
                i++;
            }
        }
        return elements;
    }

    //swap single element
    public static void swap(int[] elements, int aIdx, int bIdx) {
        int temp = elements[aIdx];
        elements[aIdx] = elements[bIdx];
        elements[bIdx] = temp;
    }

    //re-arrange elements to match index and value
    //if no element is found set value to -1
    private static int[] rearrangeElementsToMatchIndexAndValue1(int[] elements) {
        int x = 0, y = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != -1 && elements[i] != i) {
                x = elements[i];

                // check if desired place is not vacate
                while (elements[x] != -1 && elements[x] != x) {
                    // store the value from desired place
                    y = elements[x];
                    // place the x to its correct position
                    elements[x] = x;
                    // now y will become x, now search the place for x
                    x = y;
                }
                // place the x to its correct position
                elements[x] = x;

                // check if while loop hasn't set the correct value at elements[i]
                if (elements[i] != i) {
                    // if not then put -1 at the vacated place as element is not found
                    elements[i] = -1;
                }
            }
        }
        return elements;
    }

    //using hashset place the elements to right place
    private static int[] rearrangeElementsToMatchIndexAndValue(int[] elements) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != -1 && elements[i] != i) numberSet.add(i);
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != -1 && elements[i] != i) {
                if (numberSet.contains(i)) elements[i] = i;
                else elements[i] = -1;
            }
        }
        return elements;
    }

    public static void printElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // -1 -1 6 1 9 3 2 -1 4 -1
        // 19 7 0 3 18 15 12 6 1 8 11 10 9 5 13 16 2 14 17 4

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("swap elements iteratively and place it at right index: ");
        printElements(rearrangeElementsToMatchIndexAndValue2(elements));

        //reset elements
        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Iteratively find value and place it at right index: ");
        printElements(rearrangeElementsToMatchIndexAndValue1(elements));

        //reset elements
        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Place values at right index using hashset : ");
        printElements(rearrangeElementsToMatchIndexAndValue(elements));

    }

}
