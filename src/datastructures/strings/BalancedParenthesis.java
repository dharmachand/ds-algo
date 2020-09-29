package datastructures.strings;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String YES = "YES";
    public static final String NO = "NO";
    private static Hashtable<Character, Character> parenthesisPairsLookup = new Hashtable<>();

    private static String isBalanced(String s) {
        boolean isBalanced = false;
        int i;
        Stack<Character> parenthesisStack = new Stack<>();
        for (i = 0; i < s.length(); i++) {
            if (parenthesisPairsLookup.containsValue(s.charAt(i))) {
                parenthesisStack.push(s.charAt(i));
            } else if (parenthesisPairsLookup.containsKey(s.charAt(i))) {
                char c = parenthesisStack.pop();
                if (parenthesisPairsLookup.get(s.charAt(i)) != c) break;
            } else {
                throw new IllegalArgumentException("Not a valid parenthesis");
            }
        }
        if (parenthesisStack.isEmpty() && i == s.length()) isBalanced = true;
        if (isBalanced) return YES;

        else return NO;
    }

    private static void buildLookupTable() {
        parenthesisPairsLookup.put('}', '{');
        parenthesisPairsLookup.put(']', '[');
        parenthesisPairsLookup.put(')', '(');
    }

    public static void main(String[] args) {
        System.out.println("Enter string");
        String s = scanner.nextLine();

        buildLookupTable();
        System.out.println("isBalanced: " + isBalanced(s));
    }


}
