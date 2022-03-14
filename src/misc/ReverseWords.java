package misc;

public class ReverseWords {

    public static final char BLANK = ' ';

    public static void main(String[] args) {
        char[] sentence = {BLANK, 'H', 'e', 'l', 'l', 'o', 'o', BLANK,
                BLANK, 'J', 'a', 'v', 'a', BLANK, BLANK,
                'W', 'o', 'r', 'l', 'd', BLANK};
        System.out.println(String.valueOf(sentence));

        reverseWords(sentence);

        System.out.println(String.valueOf(sentence));
    }

    private static void reverseWords(char[] sentence) {
        int n = sentence.length;

        // reverse whole sentence array
        reverse(sentence, 0, n);

        //reverse each word in reversed sentence array
        int start = 0, end = 0;
        while (start < n && end < n) {
            while (start < n && sentence[start] == BLANK) start++;
            end = start;
            while (end < n && sentence[end] != BLANK) end++;
            reverse(sentence, start, end);
            start = end;
        }

    }

    private static void reverse(char[] sentence, int start, int end) {
        if (end - start < 2) return;
        int left = start, right = end - 1;
        char temp;
        while (left <= right) {
            temp = sentence[left];
            sentence[left] = sentence[right];
            sentence[right] = temp;
            left++; right--;
        }
    }

}
