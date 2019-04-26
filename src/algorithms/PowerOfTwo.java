package algorithms;

import java.util.Scanner;

public class PowerOfTwo {

    private static final Scanner scanner = new Scanner(System.in);

    //Time: O(1) and Space: O(1)
    public static boolean isPowOfTwoUsingBitwise(int num) {
        return ((num & (num - 1)) == 0);
    }

    //Time: O(logn) and space: O(1)
    public static boolean isPowOfTwo(int num) {
        while (num > 2) {
            if (num % 2 != 0) return false;
            num = num / 2;
        }
        if (num == 0 || num == 2) return true;
        else return false;
    }


    public static void main(String[] args) {

        System.out.println("Enter Number: ");
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println("Is power of 2 (Bitwise): " + isPowOfTwoUsingBitwise(num));
        System.out.println("Is power of 2: " + isPowOfTwo(num));
    }
}
