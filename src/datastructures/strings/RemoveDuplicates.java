package datastructures.strings;

import datastructures.stacks.Stack;

public class RemoveDuplicates {
    /*
     * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent
     * and equal letters, and removing them. We repeatedly make duplicate removals on S until we no longer can.
     * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
     *
     */

    public static String removeDuplicatesUsingStack(String S) {
        Stack<Character> stk = new Stack<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (!stk.isEmpty() && stk.peek() == S.charAt(i)) stk.pop();
            else stk.push(S.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.toString();
    }

    public static String removeDuplicatesUsingString(String S) {
        StringBuilder sb = new StringBuilder(S);
        int i;
        while (hasDuplicates(sb.toString())) {
            i = 0;
            while (i < sb.length() - 1) {
                if (sb.charAt(i) == sb.charAt(i + 1)) sb.delete(i, i + 2);
                else i++;
            }
        }
        return sb.toString();
    }

    private static boolean hasDuplicates(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return true;
        }
        return false;
    }

    public static String removeDuplicatesUsingCharArray(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }


    public static void main(String[] args) {
        System.out.println("UsingString: " + removeDuplicatesUsingString("abbaca"));
        System.out.println("UsingString: " + removeDuplicatesUsingString("aaaaaaaa"));

        System.out.println("UsingStack: " + removeDuplicatesUsingStack("abbaca"));

        System.out.println("UsingCharArray: " + removeDuplicatesUsingCharArray("abbaca"));
    }

}
