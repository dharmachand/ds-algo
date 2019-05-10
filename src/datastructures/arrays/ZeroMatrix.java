package datastructures.arrays;

import java.util.Scanner;

public class ZeroMatrix {

    private static final Scanner scanner = new Scanner(System.in);

    //if any element is 0 update its entire row and col with 0s
    public static void zeroMatrix(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfCols =  matrix[0].length; //in matrix all rows will have same no. of cols
        boolean[] rowFlag = new boolean[noOfRows];
        boolean[] colFlag = new boolean[noOfCols];
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                if (matrix[row][col] == 0) {
                    rowFlag[row] = true;
                    colFlag[col] = true;
                }
            }
        }
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                if (rowFlag[row] || colFlag[col]) matrix[row][col] = 0;
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

        System.out.println("Updated matrix: ");
        zeroMatrix(matrix);
        printMatrix(matrix);

        scanner.close();
    }
}
