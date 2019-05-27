package datastructures.arrays;

import java.util.Scanner;

public class MatrixRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static int[][] rotateClockWiseWithExtraDs(int[][] matrix) {
        int noOfRows = matrix.length; //in square matrix all rows will have same no. of cols
        int[][] rotatedMatrix = new int[noOfRows][noOfRows];
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfRows; col++) {
                rotatedMatrix[row][col] = matrix[noOfRows - col - 1][row];
            }
        }
        return rotatedMatrix;
    }

    //https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space
    public static void rotateClockWise(int[][] matrix) {
        int noOfRows = matrix.length; //in matrix all rows will have same no. of cols
        int temp;
        for (int row = 0; row < noOfRows / 2; row++) {
            for (int col = row; col < noOfRows - row - 1; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[noOfRows - col - 1][row];
                matrix[noOfRows - col - 1][row] = matrix[noOfRows - row - 1][noOfRows - col - 1];
                matrix[noOfRows - row - 1][noOfRows - col - 1] = matrix[col][noOfRows - row - 1];
                matrix[col][noOfRows - row - 1] = temp;
            }
        }

    }

    public static void transpose(int[][] matrix) {
        int noOfRows = matrix.length; //for square matrix noOfRows = noOfCols

        //make row as col and col as row
        for (int row = 0; row < noOfRows; row++) {
            for (int col = row; col < noOfRows; col++) {
                swap(matrix, row, col);
            }
        }
    }

    public static void swap(int[][] matrix, int row, int col) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }

    public static void verticallyFlip(int[][] matrix) {
        int noOfRows = matrix.length; //for square matrix noOfRows = noOfCols

        //flip vertically
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfRows / 2; col++) {
                verticallyFlip(matrix, row, col);
            }
        }
    }

    public static void verticallyFlip(int[][] matrix, int row, int col) {
        int noOfRows = matrix.length; //for square matrix noOfRows = noOfCols
        int temp = matrix[row][col];
        matrix[row][col] = matrix[row][noOfRows - col - 1];
        matrix[row][noOfRows - col - 1] = temp;
    }

    public static void horizontallyFlip(int[][] matrix) {
        int noOfRows = matrix.length; //for square matrix noOfRows = noOfCols

        //flip vertically
        for (int row = 0; row < noOfRows / 2; row++) {
            for (int col = 0; col < noOfRows; col++) {
                horizontallyFlip(matrix, row, col);
            }
        }
    }

    public static void horizontallyFlip(int[][] matrix, int row, int col) {
        int noOfRows = matrix.length; //for square matrix noOfRows = noOfCols
        int temp = matrix[row][col];
        matrix[row][col] = matrix[noOfRows - row - 1][col];
        matrix[noOfRows - row - 1][col] = temp;
    }

    public static void rotateCounterClockWiseByTransposeAndHFlip(int[][] matrix) {
        //step-1
        transpose(matrix);

        //step-2
        horizontallyFlip(matrix);
    }

    public static void rotateClockWiseByTransposeAndVFlip(int[][] matrix) {
        //step-1
        transpose(matrix);

        //step-2
        verticallyFlip(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        int noOfRows = matrix.length; //in square matrix all rows will have same no. of cols
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfRows; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(""); //start next row
        }
    }

    private static void populateMatrix(int[][] matrix, int noOfRows) {
        System.out.println("Enter matrix row by row: ");
        for (int row = 0; row < noOfRows; row++) {
            String[] rowElements = scanner.nextLine().split(" ");
            if (rowElements.length > noOfRows) throw new IllegalArgumentException("invalid no. of cols in a row");
            for (int col = 0; col < rowElements.length; col++) {
                matrix[row][col] = Integer.parseInt(rowElements[col]);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter size of square matrix N (as in NxN): ");
        String size = scanner.nextLine();
        int noOfRows = Integer.parseInt(size);

        int[][] matrix = new int[noOfRows][noOfRows];

        populateMatrix(matrix, noOfRows);

        System.out.println("Matrix after rotation by 90 degree clock-wise (with extra DS): ");
        printMatrix(rotateClockWiseWithExtraDs(matrix));

        System.out.println("Matrix after rotation by 90 degree clock-wise (in place): ");
        rotateClockWise(matrix);
        printMatrix(matrix);

        //to reset matrix to original one
        for (int i = 0; i < 3; i++) {
            rotateClockWise(matrix);
        }

        System.out.println("Matrix after rotation by 90 degree clock-wise (in place): ");
        System.out.println("(By transposing and flipping vertically)");
        rotateClockWiseByTransposeAndVFlip(matrix);
        printMatrix(matrix);

        //to reset matrix to original one
        for (int i = 0; i < 3; i++) {
            rotateClockWise(matrix);
        }

        System.out.println("Matrix after transposing (in place): ");
        transpose(matrix);
        printMatrix(matrix);

        //reset matrix as original
        transpose(matrix);

        System.out.println("Matrix after flipping vertically (in place): ");
        verticallyFlip(matrix);
        printMatrix(matrix);

        //reset matrix as original
        verticallyFlip(matrix);

        System.out.println("Matrix after flipping horizontally (in place): ");
        horizontallyFlip(matrix);
        printMatrix(matrix);

        //reset matrix as original
        horizontallyFlip(matrix);

        System.out.println("Matrix after rotation by 90 degree counter-clock-wise (in place): ");
        System.out.println("(By transposing and flipping horizontally)");
        rotateCounterClockWiseByTransposeAndHFlip(matrix);
        printMatrix(matrix);

        scanner.close();
    }
}
