package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    /*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.*/

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        generate(rows, numRows);
        return rows;
    }

    public static void generate(List<List<Integer>> rows, int numRows) {
        if (numRows == 1) rows.add(Arrays.asList(1));
        else if (numRows > 1) {
            generate(rows, numRows - 1);
            List<Integer> previousRow = rows.get(numRows - 2);
            List<Integer> currRow = new ArrayList<>();
            for (int row = 0; row < previousRow.size(); row++) {
                if (row == 0) currRow.add(1);
                if (row > 0) currRow.add(previousRow.get(row) + previousRow.get(row - 1));
                if (row == previousRow.size() - 1) currRow.add(1);
            }
            rows.add(currRow);
        }
    }

    public static List<List<Integer>> generateIterative(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> currRow;

        for (int row = 0; row < numRows; row++) {
            currRow =  new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) currRow.add(1);
                else currRow.add(rows.get(row - 1).get(col - 1)
                        + rows.get(row - 1).get(col));
            }
            rows.add(currRow);
        }

        return rows;
    }

    public static void main(String[] args) {
        System.out.println(generateIterative(5));
        System.out.println(generate(5));
    }
}
