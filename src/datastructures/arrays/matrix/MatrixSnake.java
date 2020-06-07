package datastructures.arrays.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixSnake {

    private static final Scanner scanner = new Scanner(System.in);

    /* Snake traversal of a MxN matrix */
    public static List<Integer> snakeTraversalOfMatrix(int[][] matrix) {
        List<Integer> path = new ArrayList<>();
        int noOfRows = matrix.length;
        int noOfCols =  matrix[0].length;

        int colIdx = 0, rowIdx = 0;
        while (rowIdx < noOfRows && colIdx < noOfCols) {
            // RIGHT
            for (int col = rowIdx; col < noOfCols; col++) {
                path.add(matrix[rowIdx][col]);
            }
            rowIdx++;

            // DOWN
            for (int row = rowIdx; row < noOfRows; row++) {
                path.add(matrix[row][noOfCols - 1]);
            }
            noOfCols--;

            // LEFT
            if (rowIdx < noOfRows) {
                for (int col = noOfCols - 1; col >= colIdx; col--) {
                    path.add(matrix[noOfRows - 1][col]);
                }
                noOfRows--;
            }

            // UP
            if (colIdx < noOfCols) {
                for (int row = noOfRows - 1; row >= rowIdx; row--) {
                    path.add(matrix[row][colIdx]);
                }
                colIdx++;
            }
        }

        return path;
    }

    public static void main(String[] args) {

        System.out.println("Enter size of matrix (MxN): ");
        String[] size = scanner.nextLine().split("x");
        int noOfRows = Integer.parseInt(size[0]);
        int noOfCols = Integer.parseInt(size[1]);

        int[][] matrix = new int[noOfRows][noOfCols];

        System.out.println("Enter matrix row by row: ");
        for (int row = 0; row < noOfRows; row++) {
            String[] rowElements = scanner.nextLine().split(" ");
            if (rowElements.length > noOfCols) throw new IllegalArgumentException("invalid no. of cols in a row");
            for (int col = 0; col < rowElements.length; col++) {
                matrix[row][col] = Integer.parseInt(rowElements[col]);
            }
        }

        System.out.println("Snake Traversal of matrix: ");
        List<Integer> path = snakeTraversalOfMatrix(matrix);
        System.out.println(path);

        scanner.close();
    }
}
