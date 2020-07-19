package datastructures.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private static void printMatrixSpirally(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int rowBegin = 0, rowEnd = m - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            //Top
            for (int i = colBegin; i <= colEnd; i++) {
                spiralOrder.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //Right
            for (int i = rowBegin; i <= rowEnd; i++) {
                spiralOrder.add(matrix[i][colEnd]);
            }
            colEnd--;

            //Bottom
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    spiralOrder.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //Left
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    spiralOrder.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        System.out.println(spiralOrder);

    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        // Input::
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // Expected Output::
        // 1 2 3 6 9 8 7 4 5

        //int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        // Input::
        // 1  2  3  4
        // 5  6  7  8
        // 9 10 11 12
        // Expected Output::
        // 1 2 3 4 8 12 11 10 9 5 6 7

        //int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // Input::
        // 1  2  3  4
        // 5  6  7  8
        // 9 10 11 12
        //13 14 15 16
        // Expected Output::
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        printMatrixSpirally(mat);
    }




}
