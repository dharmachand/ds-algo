package datastructures.strings;

import java.util.Scanner;

public class UniqueString {

    public static final Scanner scanner = new Scanner(System.in);
    public static final int NO_OF_CHARS = 256;

    //without using extra data structure
    //Time Complexity: O(n) & Space Complexity: O(1)
    //this works for only apha-numeric string
    private static boolean isUniqueBetterWithOutExtraDs(String s) {
        boolean isUnique = true;
        int checker = 0;
        // Assuming string can have characters a-z
        // this has 32 bits set to 0
        int bitAtIndex;
        for (int i = 0; i < s.length(); i++) {
            bitAtIndex = s.charAt(i) - 'a'; //index relative to char a
            // if that bit is already set in checker,
            // set isUnique to false
            if ((checker & (1 << bitAtIndex)) > 0) {
                isUnique = false;
                break;
            }
            checker = checker | (1 << bitAtIndex);
        }
        return isUnique;
    }

    //using extra data structure
    //Time Complexity: O(n) & Space Complexity: O(n)
    private static boolean isUniqueWithExtraDs(String s) {
        boolean isUnique = true;
        int[] charArray = new int[NO_OF_CHARS];
        Character c;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            charArray[c] += 1;
            if (charArray[c] > 1) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

    //without using extra data structure
    //Time Complexity: O(n pow 2) & Space Complexity: O(1)
    private static boolean isUniqueWithOutExtraDs(String s) {
        boolean isUnique = true;
        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.substring(0, i).contains(Character.toString(s.charAt(i)))) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        String s = scanner.nextLine();

        System.out.println("input string is unique (without extra DS): " + isUniqueWithOutExtraDs(s));
        System.out.println("input string is unique (using extra DS): " + isUniqueWithExtraDs(s));
        System.out.println("input string is unique (without using extra DS efficiently): " + isUniqueBetterWithOutExtraDs(s));
    }

}
