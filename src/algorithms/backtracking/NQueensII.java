package algorithms.backtracking;

import java.util.Arrays;

public class NQueensII {
    /*
        The n-queens puzzle is the problem of placing n queens on an n×n chessboard
        such that no two queens attack each other.
     */

    private static int count = 0;
    public static int totalNQueensII(int n) {
        int[] queue = new int[n];
        backtrack(0, queue, n);
        return count;
    }

    private static void backtrack(int row,int[] queue,int n) {
        if(row == n){
            count++;
        } else {
            for(int i = 0; i < n; i++){
                if(isOk(row, i, queue)) {
                    queue[row] = i;
                    //System.out.println(Arrays.toString(queue));
                    backtrack(row + 1, queue, n);
                }
            }
        }
    }

    private static boolean isOk(int row,int col,int[] queue) {
        //System.out.println("row: " + row + " col: " + col + " ====> " + Arrays.toString(queue));
        int leftUp = col - 1, rightUp = col + 1;
        int n = queue.length;
        for(int i = row - 1; i >= 0; i--) {
            if(queue[i] == col) return false;
            if(leftUp >= 0 && queue[i] == leftUp) return false;
            if(rightUp < n && queue[i] == rightUp) return false;
            leftUp--;
            rightUp++;
        }
        //System.out.println(" === isOk === ");
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueensII(4));
    }
}
