package algorithms.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    /*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    */

    private static Map<String, String> phone = new HashMap()
    {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.equals("")) return combinations;

        letterCombinations(digits, combinations, "");

        return combinations;
    }

    private static void letterCombinations(String nextDigits, List<String> combinations, String combination) {
        if (nextDigits.length() == 0) {
            combinations.add(combination);
            return;
        }

        String digit = nextDigits.substring(0, 1);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = phone.get(digit).substring(i, i + 1);
            letterCombinations(nextDigits.substring(1), combinations, combination + letter);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
