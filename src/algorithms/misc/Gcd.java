package algorithms.misc;

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

    public static int findGcdItr(int[] elements) {
        int result = 0;
        for (int i = 0; i < elements.length; i++) {
            result = findGcdItr(elements[i], result);
        }
        return result;
    }

    public static int findGcdItr(int a, int b) {
        if (b == 0) return a;
        int gcd = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) gcd = i;
        }
        return gcd;
    }


    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Gcd: " + findGcd(elements));
        System.out.println("Gcd: " + findGcdItr(elements));

    }
}
