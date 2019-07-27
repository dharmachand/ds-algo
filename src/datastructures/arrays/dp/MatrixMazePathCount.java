package datastructures.arrays.dp;

import java.util.Scanner;

public class MatrixMazePathCount {

    private static final Scanner scanner = new Scanner(System.in);

    public static int countPaths(int m, int n){
        int[][] memo = new int[m][n];

        //first row will have only one path
        for (int col = 0; col < n; col++) {
            memo[0][col] = 1;
        }

        //first col will have only one path
        for (int row = 0; row < m; row++) {
            memo[row][0] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                memo[row][col] = memo[row - 1][col] + memo[row][col - 1];
            }
        }

        return memo[m - 1][n - 1];
    }



    public static void main(String[] args) {

        System.out.println("Enter size of matrix (MxN): ");
        String[] size = scanner.nextLine().split("x");
        int noOfRows = Integer.parseInt(size[0]);
        int noOfCols = Integer.parseInt(size[1]);

        int count = countPaths(noOfRows, noOfCols);
        System.out.println("Count of possible paths from top left to bottom right in matrix: " + count);

        scanner.close();
    }
}
