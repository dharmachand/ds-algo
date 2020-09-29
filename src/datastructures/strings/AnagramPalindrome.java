package datastructures.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnagramPalindrome {

    public static final Scanner scanner = new Scanner(System.in);
    public static final char BLANK = ' ';

    //check if any permutation/anagram is palindrome
    public static boolean hasPalindromeAnagram(String s) {
        boolean hasPalindromeAnagram = false;

        //get all string permutations/anagrams
        List<String> anagrams = getAllAnagramsOfString(s);

        //check if any of the permutation/anagram is palindrome
        for (int i = 0; i < anagrams.size(); i++) {
            if (isPalindrome(anagrams.get(i))) {
                hasPalindromeAnagram = true;
                break;
            }
        }
        return hasPalindromeAnagram;
    }

    //ignore blank space and check if its palindrome
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() -1;
        while (i < j) {
            if (s.charAt(i) == BLANK) i++;
            if (s.charAt(j) == BLANK) j--;
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //get all string permutations/anagrams
    public static List<String> getAllAnagramsOfString(String s) {
        List<String> anagrams = new ArrayList<>();
        permutate(anagrams, s, 0, s.length() - 1);
        return  anagrams;
    }

    //recursion tree for permutation
    //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string
    private static void permutate(List<String> anagrams, String s, int left, int right) {
        if (left == right) {
            anagrams.add(s);
        } else {
            for (int i = left; i <= right; i++) {
                s = swap(s, left, i);
                permutate(anagrams, s, left + 1, right);
                s = swap(s, left, i);
            }
        }
    }

    public static List<String> getAllPalindromeAnagrams(String s) {
        List<String> palindromeAnagrams = new ArrayList<>();

        //get all string permutations/anagrams
        List<String> anagrams = getAllAnagramsOfString(s);

        //check if any of the permutation/anagram is palindrome
        for (int i = 0; i < anagrams.size(); i++) {
            if (isPalindrome(anagrams.get(i))) {
                palindromeAnagrams.add(anagrams.get(i));
            }
        }
        return palindromeAnagrams;
    }


    private static String swap(String s, int fromIndex, int toIndex) {
        char[] charArray = s.toCharArray();
        char temp = charArray[fromIndex];
        charArray[fromIndex] = charArray[toIndex];
        charArray[toIndex] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        String s = scanner.nextLine().toLowerCase();

        List<String> anagrams = getAllAnagramsOfString(s);
        System.out.println("anagrams ( total: " + anagrams.size() + " ): " + anagrams);

        List<String> palindromeAnagrams = getAllPalindromeAnagrams(s);
        System.out.println("palindrome anagrams ( total: " + palindromeAnagrams.size() + " ): " + palindromeAnagrams);

        System.out.println("String has permutation palindrome: " + hasPalindromeAnagram(s));

    }

}
