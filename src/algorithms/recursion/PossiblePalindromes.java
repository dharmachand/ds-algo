package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossiblePalindromes {
    /**
     * Find all palindromic decompositions of a given string s.
     *
     *
     *
     * A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.
     *
     *
     *
     * Example
     *
     * Input: "abracadabra"
     *
     *
     *
     * Output: [ "a|b|r|a|c|a|d|a|b|r|a", "a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a" ]
     *
     *
     *
     * Notes
     *
     * Input Parameters: There is only one argument: string s.
     *
     *
     *
     * Output: Return array of string res, containing ALL possible palindromic decompositions of given string. To separate substrings in the decomposed string, use '|' as a separator between them.
     *
     * You need not to worry about the order of strings in your output array. Like for s = "aa", arrays ["a|a", "aa"] and ["aa", "a|a"] both will be accepted.
     * In any string in your returned array res, order of characters should remain the same as in the given string. (i.e. for s = "ab" you should return ["a|b"] and not ["b|a"].)
     * Any string in the returned array should not contain any spaces. e.g. s = "ab" then ["a|b"] is expected, ["a |b"] or ["a| b"] or ["a | b"] will give the wrong answer.
     *
     *
     * Constraints:
     *
     * 1 <= |s| <= 20
     * s only contains lowercase letters ('a' - 'z').
     *
     *
     * Any string is its own substring.
     */

    /*
     * Complete the function below.
     */
    static String[] generatePalindromicDecompositions(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.isEmpty()) {
            return null;
        }
        helper(s.toCharArray(), 0, new char[s.length() * 2], 0, result);
        String[] arr = new String[result.size()];
        int i = 0;
        for(String str : result) {
            arr[i] = str;
            i++;
        }
        return arr;
    }

    static void helper(char[] arr, int i, char[] slate, int k, List<String> result) {
        if(i == arr.length) {
            result.add(new String(slate, 0, k-1));
            return;
        }
        for(int j = i; j < arr.length; j++) {
            slate[k++] = arr[j];
            if(isPalindrome(arr, i, j)) {
                slate[k] = '|';
                helper(arr, j + 1, slate, k + 1, result);
            }
        }
    }

    static boolean isPalindrome(char[] arr, int p1, int p2) {
        while(p1 < p2) {
            if(arr[p1++] != arr[p2--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generatePalindromicDecompositions("abracadabra")));
    }

}
