package datastructures.arrays;

import java.util.Scanner;

public class MatrixRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static int[][] rotateClockWiseWithExtraDs(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfCols =  matrix[0].length; //in matrix all rows will have same no. of cols
        int[][] rotatedMatrix = new int[noOfRows][noOfCols];
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                rotatedMatrix[row][col] = matrix[noOfCols - col - 1][row];
            }
        }
        return rotatedMatrix;
    }

    //https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space
    public static void rotateClockWise(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfCols =  matrix[0].length; //in matrix all rows will have same no. of cols
        int temp;
        for (int row = 0; row < noOfRows / 2; row++) {
            for (int col = row; col < noOfCols - row - 1; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[noOfCols - col - 1][row];
                matrix[noOfCols - col - 1][row] = matrix[noOfRows - row - 1][noOfCols - col - 1];
                matrix[noOfRows - row - 1][noOfCols - col - 1] = matrix[col][noOfRows - row - 1];
                matrix[col][noOfRows - row - 1] = temp;
            }
        }

    }

    private static void printMatrix(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length; //in matrix all rows will have same no. of cols
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(""); //start next row
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter size of square matrix N (as in NxN): ");
        String size = scanner.nextLine();
        int noOfRows = Integer.parseInt(size);
        int noOfCols = Integer.parseInt(size);

        int[][] matrix = new int[noOfRows][noOfCols];

        System.out.println("Enter matrix row by row: ");
        for (int row = 0; row < noOfRows; row++) {
            String[] rowElements = scanner.nextLine().split(" ");
            if (rowElements.length > noOfCols) throw new IllegalArgumentException("invalid no. of cols in a row");
            for (int col = 0; col < rowElements.length; col++) {
                matrix[row][col] = Integer.parseInt(rowElements[col]);
            }
        }

        System.out.println("Matrix after rotation by 90 degree clock-wise (with extra DS): ");
        printMatrix(rotateClockWiseWithExtraDs(matrix));

        System.out.println("Matrix after rotation by 90 degree clock-wise (in place): ");
        rotateClockWise(matrix);
        printMatrix(matrix);

        scanner.close();
    }
}
