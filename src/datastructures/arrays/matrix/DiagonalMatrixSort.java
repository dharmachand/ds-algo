package datastructures.arrays.matrix;


import java.util.*;

public class DiagonalMatrixSort {
    public static int[][] diagonalSort(int[][] mat) {
        int noOfRows = mat.length;
        int noOfCols = mat[0].length;

        Map<Integer, List<Integer>> diagMap = new HashMap<>();
        List<Integer> diag;
        int diff;
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                diff = row - col;
                if (!diagMap.containsKey(diff)) {
                    diag = new ArrayList<>();
                    diag.add(mat[row][col]);
                    diagMap.put(diff, diag);
                } else {
                    diag = diagMap.get(diff);
                    diag.add(mat[row][col]);
                }
            }
        }

        for(Integer k : diagMap.keySet()) {
            Collections.sort(diagMap.get(k));
        }

        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                diff = row - col;
                mat[row][col] = diagMap.get(diff).get(0);
                diagMap.get(diff).remove(0);
            }
        }
        return mat;
    }

    private static void printMatrix(int[][] mat) {
        int noOfRows = mat.length;
        int noOfCols = mat[0].length;
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                System.out.print(mat[row][col] + " ");
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
        // Expected Output::
        // 1 1 1 1
        // 1 2 2 2
        // 1 2 3 3
        System.out.println("Output: ");
        printMatrix(diagonalSort(mat));
    }


}
