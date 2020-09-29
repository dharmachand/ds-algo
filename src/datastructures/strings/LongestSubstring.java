package datastructures.strings;

import java.util.*;

public class LongestSubstring {

    private static final Scanner scanner = new Scanner(System.in);

    //sliding window approach
    //here i is one end of the window and j is other end
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0, maxLen = 0;
        Set<Character> charSet = new HashSet<>();
        while (i < n && j < n) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                charSet.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println("Enter string: ");
        String s = scanner.nextLine();

        int len = lengthOfLongestSubstring(s);
        System.out.println("Length of longest non-repeatable substring: " + len);
    }
}
