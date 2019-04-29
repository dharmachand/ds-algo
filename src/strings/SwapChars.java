package strings;

import java.util.Scanner;

public class SwapChars {

    public static final Scanner scanner = new Scanner(System.in);
    public static final char BLANK_CHAR = ' ';

    private static String swapFirstLastCharsOfWordsInSentence(String inputS) {
        if (inputS == null) return inputS;
        char[] charArray = inputS.toCharArray();
        int i = 0, j = 0;
        for (i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == BLANK_CHAR) {
                swapCharsOfWord(charArray, i - 1 , j);
                j = i + 1;
            }
        }
        swapCharsOfWord(charArray, i, j);

        return new String(charArray);
    }

    private static void swapCharsOfWord(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {

        System.out.println("Enter string: ");
        String inputS = scanner.nextLine();

        String outputS = swapFirstLastCharsOfWordsInSentence(inputS);
        System.out.println("String after swapping first last chars of all words: " + outputS);
    }

}
