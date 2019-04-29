package algorithms.bitwise;

import java.util.Scanner;

public class ModPowerOfTwo {

    private static final Scanner scanner = new Scanner(System.in);

    //Time: O(1) and Space: O(1)
    public static int isPowOfTwoUsingBitwise(int num, int d) {
        return (num & (d - 1));
    }


    public static void main(String[] args) {

        System.out.println("Enter a number: ");
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter number which is a pow of 2: ");
        int d = Integer.parseInt(scanner.nextLine());


        System.out.println("Is power of 2 (Bitwise): " + isPowOfTwoUsingBitwise(num, d));
    }
}
