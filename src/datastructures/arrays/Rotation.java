package datastructures.arrays;

import algorithms.Gcd;

import java.util.Scanner;

public class Rotation {

    private static final Scanner scanner = new Scanner(System.in);

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

    private static void rotateLeftByReversal(int[] elements, int rotations) {
        reverseElements(elements, 0, rotations - 1);
        reverseElements(elements, rotations, elements.length - 1);
        reverseElements(elements, 0, elements.length - 1);
    }

    public static void reverseElements(int[] elements, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(elements, i , j);
            i++;
            j--;
        }
    }

    //swap single element
    public static void swap(int[] elements, int aIdx, int bIdx) {
        int temp = elements[aIdx];
        elements[aIdx] = elements[bIdx];
        elements[bIdx] = temp;
    }

    private static void rotateLeftByBlockSwap(int[] elements, int rotations) {
        //A = elements[0..rotations - 1] and B = elements[rotations..elements.length - 1]
        int i, j;
        if (rotations == 0 || rotations == elements.length) { return; }
        i = rotations;
        j = elements.length - rotations;
        while (i != j) {
            if(i < j) { /*A is shorter*/
                swap(elements, rotations - i, rotations + j - i, i);
                j -= i;
            } else { /*B is shorter*/
                swap(elements, rotations - i, rotations, j);
                i -= j;
            }
        }
        /*Finally, block swap A and B*/
        swap(elements, rotations - i, rotations, i);
    }

    //swap a block
    public static void swap(int[] elements, int aIdx, int bIdx, int blockSize) {
        int i, temp;
        for(i = 0; i < blockSize; i++) {
            temp = elements[aIdx + i];
            elements[aIdx + i] = elements[bIdx + i];
            elements[bIdx + i] = temp;
        }
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

        rotateLeft(elements, rotations); //rotate one by one
        System.out.println("");
        System.out.println("Left Rotated elements one-by-one: ");
        printElements(elements);

        //reset elements
        rotateRight(elements, rotations);

        rotateLeftByJuggling(elements, rotations); //rotate by juggling
        System.out.println("");
        System.out.println("Left Rotated elements by juggling: ");
        printElements(elements);

        //reset elements
        rotateRight(elements, rotations);

        rotateLeftByReversal(elements, rotations); //rotate by reversal
        System.out.println("");
        System.out.println("Left Rotated elements by reversal: ");
        printElements(elements);

        //reset elements
        rotateRight(elements, rotations);

        rotateLeftByBlockSwap(elements, rotations); //rotate by block swap
        System.out.println("");
        System.out.println("Left Rotated elements by block swap: ");
        printElements(elements);


        scanner.close();
    }
}
