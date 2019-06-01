package datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixMaze {

    private static final Scanner scanner = new Scanner(System.in);

    /* All the possible paths from TOP LEFT to BOTTOM RIGHT of a MxN matrix
     with the constraints that from each cell you can only MOVE either to RIGHT or DOWN */
    public static List<String> traverseMatrix(int[][] matrix) {
        List<String> paths = new ArrayList<>();
        int noOfRows = matrix.length;
        int noOfCols =  matrix[0].length;
        int maxLengthOfPath = noOfRows + noOfCols - 1;

        traverseMatrix(matrix, 0, 0, new int[maxLengthOfPath], 0, paths);

        return paths;
    }

    /* row, col: Current position (For the first call use 0,0)
       idx:   Next index to be filed in path array
       path[0..idx-1]: The path traversed till now
       (Array to hold the path need to have space for at least m+n elements)
       paths: list of all possible paths*/
    public static void traverseMatrix(int[][] matrix, int row, int col, int[] path, int idx, List<String> paths) {
        int noOfRows = matrix.length;
        int noOfCols =  matrix[0].length;
        path[idx] = matrix[row][col];

        // Reached bottom of matrix i.e last row of matrix
        // Now you can only traverse to right to reach BOTTOM RIGHT of matrix
        if (row == noOfRows -1) {
            for (int colIdx = col + 1; colIdx < noOfCols;  colIdx++) {
                path[idx + colIdx - col] = matrix[row][colIdx];
            }
            //add path to paths
            paths.add(Arrays.toString(path));
            return;
        }

        // Reached right most of matrix i.e last col of matrix
        // Now you can only traverse to down to reach BOTTOM RIGHT of matrix
        if (col == noOfCols - 1) {
            for (int rowIdx = row + 1; rowIdx < noOfRows; rowIdx++) {
                path[idx + rowIdx - row] = matrix[rowIdx][col];
            }

            //add path to paths
            paths.add(Arrays.toString(path)); //add path to paths
            return;
        }

        // At every cell you have 2 choices 1. go to right 2. go down
        // All paths that are possible after moving right
        traverseMatrix(matrix, row, col + 1, path, idx + 1, paths); // go to right
        // All paths that are possible after moving down
        traverseMatrix(matrix, row + 1, col, path, idx + 1, paths); // go down
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

        System.out.println("All possible paths from top left to bottom right in matrix: ");
        List<String> paths = traverseMatrix(matrix);
        for (String path : paths) {
            System.out.println(path);
        }

        scanner.close();
    }
}
