package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZigZagConversion {

    private static final Scanner scanner = new Scanner(System.in);

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {

        System.out.println("Enter string: ");
        String s = scanner.nextLine();

        System.out.println("Enter string: ");
        int numRows = Integer.parseInt(scanner.nextLine());

        String output = convert(s, numRows);
        System.out.println("String after ZigZag Conversion: " + output);
    }
}
