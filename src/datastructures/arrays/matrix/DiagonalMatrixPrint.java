package datastructures.arrays.matrix;


public class DiagonalMatrixPrint {
    public static void printMatrixDiagonallyUpwardBottomLeft(int[][] mat) {
        int noOfRows = mat.length;
        int noOfCols = mat[0].length;
        int row, col;
        //diagonals starting from first col and ending on first row
        for (int k = 0; k <= noOfRows - 1; k++) {
            row = k;
            col = 0;
            while (row >= 0) {
                System.out.print(mat[row][col] + " ");
                row = row - 1;
                col = col + 1;
            }
            System.out.println("");
        }

        //diagonals starting from last row and ending on last col
        for (int k = 1; k <= noOfCols - 1; k++) {
            row = noOfRows - 1;
            col = k;
            while (col <= noOfCols - 1) {
                System.out.print(mat[row][col] + " ");
                row = row - 1;
                col = col + 1;
            }
            System.out.println("");
        }

    }

    public static void printMatrixDiagonallyDownwardTopLeft(int[][] mat) {
        int noOfRows = mat.length;
        int noOfCols = mat[0].length;
        int row, col;
        // diagonals starting from first col and ending on last row
        for (int k = noOfRows - 1; k >= 0; k--) {
            row = k;
            col = 0;
            while (row <= noOfRows - 1) {
                System.out.print(mat[row][col] + " ");
                row = row + 1;
                col = col + 1;
            }
            System.out.println("");
        }

        //diagonals starting from first row and ending on last col
        for (int k = 1; k <= noOfCols - 1; k++) {
            row = 0;
            col = k;
            while (col <= noOfCols - 1) {
                System.out.print(mat[row][col] + " ");
                row = row + 1;
                col = col + 1;
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        // Input::
        // 3 3 1 1
        // 2 2 1 2
        // 1 1 1 2
        // Expected Output:: printMatrixDiagonallyUpward
        // 3
        // 2 3
        // 1 2 1
        // 1 1 1
        // 1 2
        // 2
        System.out.println("DiagonallyUpwardBottomLeft:");
        printMatrixDiagonallyUpwardBottomLeft(mat);

        //int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        // Input::
        // 3 3 1 1
        // 2 2 1 2
        // 1 1 1 2
        // Expected Output:: printMatrixDiagonallyDownward
        // 1
        // 2 1
        // 3 2 1
        // 3 1 2
        // 1 2
        // 1
        System.out.println("DiagonallyDownwardTopLeft:");
        printMatrixDiagonallyDownwardTopLeft(mat);

    }


}
