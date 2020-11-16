package algorithms.recursion;

public class DigitPermutations {
    //print all decimal numbers with n digits in increasing order

    public static void printDigitPermutations(int n) {
        printDigitPermutations(n, 0, new StringBuilder(""));
    }

    public static void printDigitPermutations(int n, int start, StringBuilder sb) {
        if (n == 0) System.out.println(sb.toString());
        else {
            for (int i = start; i <= 9; i++) {
                sb.append(i);
                printDigitPermutations(n - 1, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        printDigitPermutations(2);
    }
}
