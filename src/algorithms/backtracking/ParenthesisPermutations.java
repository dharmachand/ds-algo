package algorithms.backtracking;

import java.util.ArrayList;

public class ParenthesisPermutations {

    public static ArrayList<String> combParenthesis(int noOfPairs) {
        ArrayList<String> result = new ArrayList<>();
        combParenthesis(noOfPairs, noOfPairs, new StringBuilder(), result);

        return result;
    }

    public static void combParenthesis(int remOpen, int remClose, StringBuilder sb, ArrayList<String> result) {
        if (remOpen > remClose) return;
        if (remOpen == 0 && remClose == 0) result.add(sb.toString());
        else {
            if (remOpen > 0) {
                sb.append("(");
                combParenthesis(remOpen - 1, remClose, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (remClose > 0) {
                sb.append(")");
                combParenthesis(remOpen, remClose - 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Parenthesis Permutations: " + combParenthesis(2));
    }


}
