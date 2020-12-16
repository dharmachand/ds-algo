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
    static String[] generate_palindromic_decompositions(String s) {
        List<String> palinds = new ArrayList<>();
        generatePalindromeDecomp(s, 0, new StringBuilder(), palinds);
        return palinds.stream().toArray(String[]::new);
    }

    private static void generatePalindromeDecomp(String s, int pos, StringBuilder sb, List<String> palinds) {
        if (pos == s.length()) {
            palinds.add(sb.toString());
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                if (pos == 0) {
                    generatePalindromeDecomp(s, i + 1, new StringBuilder(s.substring(pos, i - pos + 1)), palinds);
                } else {
                    sb.append("|");
                    sb.append(s.substring(pos, i - pos + 1));
                    generatePalindromeDecomp(s, i + 1, sb, palinds);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate_palindromic_decompositions("abracadabra")));
    }

}
