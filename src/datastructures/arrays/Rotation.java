package datastructures.arrays;

import algorithms.Gcd;

import java.util.Scanner;

public class Rotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void rotateLeft(int[] elements, int rotations) {
        for (int j = 0; j < rotations; j++) {
            rotateLeftByOne(elements);
        }
    }

    private static void rotateLeftByOne(int[] elements) {
        int temp = elements[0];
        for (int i = 0; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[elements.length - 1] = temp;
    }


    private static void rotateLeftByJuggling(int[] elements, int rotations) {
        int gcd = Gcd.findGcd(rotations, elements.length);
        int i, j, k, temp;
        for (i = 0; i < gcd; i++) {
            temp = elements[i];
            j = i;
            while (true) {
                k = j + rotations;

                if (k >= elements.length) {
                    k = k - elements.length;
                }

                if (k == i) { break; }

                elements[j] = elements[k];
                j = k;
            }
            elements[j] = temp;
        }
    }

    public static void rotateRight(int[] elements, int rotations) {
        for (int j = 0; j < rotations; j++) {
            rotateRightByOne(elements);
        }
    }

    private static void rotateRightByOne(int[] elements) {
        int temp = elements[elements.length - 1];
        for (int i = elements.length - 1; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = temp;
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

        System.out.println("Enter no. of rotations: ");
        int rotations = Integer.parseInt(scanner.nextLine());

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        rotateRight(elements, rotations);
        System.out.println("Right Rotated elements: ");
        printElements(elements);

        //reset elements
        rotateLeft(elements, rotations);

        rotateLeftByJuggling(elements, rotations);
        System.out.println("Left Rotated elements: ");
        printElements(elements);

        scanner.close();
    }
}
