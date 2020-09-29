package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    /*
        Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
        Could you optimize your algorithm to use only O(k) extra space?
    */

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Arrays.asList(1);
        else {
            List<Integer> prevRow = getRow(rowIndex - 1);
            List<Integer> resultRow = new ArrayList<>();
            for (int row = 0; row < prevRow.size(); row++) {
                if (row == 0) resultRow.add(1);
                if (row > 0) resultRow.add(prevRow.get(row) + prevRow.get(row - 1));
                if (row == prevRow.size() - 1) resultRow.add(1);
            }
            return resultRow;
        }
    }


    public static List<Integer> getRowIterative(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>(), resultRow = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            resultRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) resultRow.add(1);
                else resultRow.add(prevRow.get(col) + prevRow.get(col - 1));
            }
            prevRow = resultRow;
        }

        return resultRow;
    }

    public static void main(String[] args) {
        System.out.println(getRowIterative(4));
        System.out.println(getRow(4));
    }
}
