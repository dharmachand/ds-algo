package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleExpressions {
    /*
     * Complete the function below.
     */
    private static String[] operators = {"", "*", "+"};
    static String[] generate_all_expressions(String s, long target) {
        List<String> exprs = new ArrayList<>();
        generateAllExpressions(s, 1, target, Character.getNumericValue(s.charAt(0)),
                new StringBuilder(s.substring(0, 1)), exprs);
        return exprs.toArray(new String[0]);
    }

    private static void generateAllExpressions(String s, int pos, long target, long partial,
                                               StringBuilder sb, List<String> exprs) {
        if (pos >= s.length()) {
            if (target == partial) exprs.add(sb.toString());
        } else {
            for (int i = 0; i < operators.length; i++) {
                int digit = Character.getNumericValue(s.charAt(pos));

                long val;
                if (operators[i].equals("*")) val =  partial *  digit;
                else if (operators[i].equals("+")) val =  partial +  digit;
                else val = partial * 10 + digit;

                sb.append(operators[i]);
                sb.append(s.substring(pos, pos + 1));
                generateAllExpressions(s, pos + 1, target, val, sb, exprs);
                sb.deleteCharAt(sb.length() - 1);
                if (!operators[i].equals("")) sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "222";
        long target = 24;
        System.out.println(Arrays.toString(generate_all_expressions(s, target)));
    }
}
