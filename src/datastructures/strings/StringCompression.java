package datastructures.strings;

import java.util.Scanner;

public class StringCompression {

    public static final Scanner scanner = new Scanner(System.in);

    private static String compressedString(String s) {
        StringBuilder compressedSb = new StringBuilder();
        int i, charCount = 1;
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) charCount++;
            else {
                compressedSb.append(s.charAt(i))
                    .append(charCount);
                charCount = 1;
            }
        }
        compressedSb.append(s.charAt(i))
                .append(charCount);
        return compressedSb.length() >= s.length() ? s : compressedSb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        String s = scanner.nextLine();

        System.out.println("compressed string: " + compressedString(s));
    }


}
