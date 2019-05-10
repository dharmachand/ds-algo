package datastructures.arrays;

import java.util.HashSet;
import java.util.Scanner;

public class Duplicates {

    private static final Scanner scanner = new Scanner(System.in);

    //TODO - Implement Logic
    private static void removeDuplicates(int[] elements) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < elements.length;) {

        }
    }

    public static void printElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        //1 2 1 3 4 5 3
        //1 2 1 3 4 5 3 6
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Elements after removing duplicates: ");
        removeDuplicates(elements);
        printElements(elements);

    }

}
