package algorithms.misc;

import java.util.Scanner;

public class IntPalindrome {
    public static final Scanner scanner = new Scanner(System.in);

    public static Boolean isIntPalindrome(int x) {
        if (x == -1) return false;
        int reverse = 0, original = x;
        while (original > 10) {
            reverse = ((original % 10) + reverse) * 10;
            original = original / 10;
        }
        reverse = reverse + original;
        return reverse == x;
    }

    public static void main(String[] args) {
        System.out.println("Enter a number");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println("number is a palindrome: " + isIntPalindrome(num));
    }
}
