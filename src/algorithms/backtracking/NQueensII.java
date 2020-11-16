package algorithms.backtracking;

public class NQueensII {
    /*
        The n-queens puzzle is the problem of placing n queens on an n×n chessboard
        such that no two queens attack each other.
     */

    private static int count = 0;
    public static int totalNQueensII(int n) {
        int[] queue = new int[n];
        backtrack(n,0, queue);
        return count;
    }

    private static void backtrack(int n, int row, int[] queue) {
        if(row == n){
            count++;
        } else {
            for(int i = 0; i < n; i++){
                if(isOk(queue, row, i)) {
                    queue[row] = i;
                    //System.out.println(Arrays.toString(queue));
                    backtrack(n, row + 1, queue);
                }
            }
        }
    }

    private static boolean isOk(int[] queue, int row, int col) {
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
