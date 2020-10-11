package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /*
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
     */

    //Approach 1: Brute Force********************Start
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private static void generateAll(char[] current, int pos, List<String> combinations) {
        if (pos == current.length) {
            if (valid(current)) combinations.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, combinations);
            current[pos] = ')';
            generateAll(current, pos + 1, combinations);
        }

    }

    private static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
    //Approach 1: Brute Force********************End

    //Approach 2: Backtracking********************Start
    public static List<String> generateParenthesis2(int n) {
        List<String> combinations = new ArrayList<>();
        generate(combinations, "", 0, 0, n);
        return combinations;
    }

    private static void generate(List<String> combinations, String curr,
                          int open, int close, int max) {
        if (curr.length() == 2 * max) {
            combinations.add(curr);
            return;
        }

        if (open < max) generate(combinations, curr + '(', open + 1, close, max);
        if (close < open) generate(combinations, curr + ')', open, close + 1, max);
    }
    //Approach 2: Backtracking********************End

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis2(3));
    }
}
