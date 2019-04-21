package algorithms;

import java.util.Scanner;

public class Gcd {

    private static final Scanner scanner = new Scanner(System.in);

    public static int findGcd(int[] elements) {
        int result = 0;
        for (int i = 0; i < elements.length; i++) {
            result = findGcd(elements[i], result);
        }
        return result;
    }

    public static int findGcd(int a, int b) {
        if (b == 0) { // we can also check a == 0 and return b
            return a;
        } else {
            return findGcd(b, a % b); //we can also do findGcd(b % a, a)
        }
    }


    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        int gcd = findGcd(elements);

        System.out.println("Gcd: " + gcd);

    }
}
