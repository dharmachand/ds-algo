package algorithms.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break Count
 *
 *
 *
 * Given a dictionary of words and a string, find the number of ways the string can be broken down into the dictionary words.
 * Return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example
 *
 * Input: Dictionary: [“kick", "start", "kickstart", "is", "awe", "some", "awesome”]. String: “kickstartisawesome”.
 *
 * Output: 4
 *
 * Here are all four ways to break down the string into the dictionary words:
 *
 * kick start is awe some
 * kick start is awesome
 * kickstart is awe some
 * kickstart is awesome
 * 4 % 1000000007 = 4 so the correct output is 4.
 */

public class WordBreakCount {
    public static int wordBreakCount(List<String> dictionary, String txt) {
        Set<String> dic = new HashSet<>();
        for (String word : dictionary) {
            dic.add(word);
        }
        int len = txt.length();
        int[] wordBreaks = new int[len + 1];
        wordBreaks[len] = 1;
        for (int i = len; i > 0; i--) {
            for (int c = 0; c < i; c++) {
                String word = txt.substring(c, i);
                if (dic.contains(word)) {
                    wordBreaks[c] += wordBreaks[i];
                    wordBreaks[c] = wordBreaks[c] % 1000000007; //to avoid integer overflow
                }
            }

        }

        return wordBreaks[0];
    }

    public static void main(String[] args) {
        String[] dict = {"kick", "start", "kickstart", "is", "awe", "some", "awesome"};
        String word = "kickstartisawesome";
        System.out.println(wordBreakCount(Arrays.asList(dict), word));
    }
}
