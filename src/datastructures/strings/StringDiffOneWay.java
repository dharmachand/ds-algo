package datastructures.strings;

import java.util.Scanner;

public class StringDiffOneWay {
    public static final Scanner scanner = new Scanner(System.in);

    //Time Complexity: O(a * b) i.e equivalent to O(n pow 2)
    //Space Complexity: O(a + b) i.e equivalent to O(n)
    public static boolean isSingleEditAway(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (Math.abs(aLen - bLen) > 1) return false;
        int edits = 0;
        int largeStrLen = Math.max(aLen, bLen);
        String largeStr = aLen >= bLen ? a : b;
        String smallStr = aLen < bLen ? a : b;
        for (int i = 0; i < largeStrLen; i++) {
            if (smallStr.indexOf(largeStr.charAt(i)) == -1) edits++;
            else if (Math.abs(i - smallStr.indexOf(largeStr.charAt(i))) > 1) return false;
            if (edits > 1) return false;
        }
        return true;
    }

    //https://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one
    //Time Complexity: O(a) if a > b else O(b) if b > a i.e equivalent to O(n)
    //Space Coplexity: O(1)
    public static boolean isSingleEditAwayBetter(String s1, String s2) {
        // Find lengths of given datastructures.strings
        int m = s1.length(), n = s2.length();

        // If difference between lengths is
        // more than 1, then datastructures.strings can't
        // be at one distance
        if (Math.abs(m - n) > 1) return false;

        int count = 0; // Count of edits

        int i = 0, j = 0;
        while (i < m && j < n) {
            // If current characters don't match
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1) return false;

                // If length of one string is
                // more, then only possible edit
                // is to remove a character
                if (m > n) i++;
                else if (m < n) j++;
                else { // If lengths of both datastructures.strings is same
                    i++;
                    j++;
                }
                // Increment count of edits
                count++;
            } else { // If current characters match
                i++;
                j++;
            }
        }

        // If last character is extra in any string
        if (i < m || j < n) count++;

        return count == 1;
    }


    public static void main(String[] args) {
        System.out.println("Enter string a: ");
        String a = scanner.nextLine();

        System.out.println("Enter string b: ");
        String b = scanner.nextLine();

        System.out.println("String b is single/zero edits away from string a: " + isSingleEditAway(a, b));
        System.out.println("String b is single/zero edits away from string a (better): " + isSingleEditAwayBetter(a, b));

    }

}
