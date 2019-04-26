package strings;

import java.util.Scanner;

public class PairStar {

    private static final Scanner scanner = new Scanner(System.in);

    public static String insertPairStar(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;
        return insertPairStar(s, 0);
    }

    public static String insertPairStar(String s, int pos) {
        if (pos == s.length() - 1) return s;
        if (s.charAt(pos) == s.charAt(pos + 1)) {
            String strBeforePos = s.substring(0, pos + 1); //includes char at Pos
            String strAfterPos = s.substring(pos + 1);
            StringBuffer newS = new StringBuffer(strBeforePos);
            newS.append("*")
                    .append(strAfterPos);
            return insertPairStar(newS.toString(), strBeforePos.length() + 1);
        } else {
            return insertPairStar(s, pos + 1);
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter string: ");
        String input = scanner.nextLine();

        String output = insertPairStar(input);
        System.out.println("String after inserting stars between pairs: " + output);
    }
}
