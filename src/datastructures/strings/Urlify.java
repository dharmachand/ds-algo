package datastructures.strings;

import java.util.Scanner;

public class Urlify {

    public static final Scanner scanner = new Scanner(System.in);
    public static final char BLANK = ' ';
    public static final String ESCAPE_BLANK = "%20";


    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        String s = scanner.nextLine();

        System.out.println("input string after urlification: " + urlify(s));

    }

    public static String urlify(String s) {
        int endOfStringIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != BLANK) endOfStringIndex = i;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder("");
        while (i < endOfStringIndex) {
            if (s.charAt(i) != BLANK) {
                sb.append(s.charAt(i));
            } else {
                sb.append(ESCAPE_BLANK);
            }
            i++;
        }
        return sb.toString();
    }

}
