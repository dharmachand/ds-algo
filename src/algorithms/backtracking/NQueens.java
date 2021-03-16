package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
        The n-queens puzzle is the problem of placing n queens on an n×n chessboard
        such that no two queens attack each other.
     */

    public static List<List<Integer>> totalNQueens(int n) {
        List<List<Integer>> boards = new ArrayList<>();
        backtrack(n,0, new ArrayList<>(), boards);
        return boards;
    }

    private static void backtrack(int n, int row, List<Integer> board, List<List<Integer>> boards) {
        if(row == n) boards.add(new ArrayList<>(board));
        else {
            for(int col = 0; col < n; col++){
                if(isOk(board, row, col)) {
                    board.add(col);
                    backtrack(n, row + 1, board, boards);
                    board.remove(board.size() - 1);
                }
            }
        }
    }

    private static boolean isOk(List<Integer> board, int row, int col) {
        for (int row1 = 0; row1 < board.size(); row1++) {
           int col1 = board.get(row1);
           if (col1 == col) return false; //same col

           int xDist = Math.abs(row1 - row);
           int yDist = Math.abs(col1 - col);
           if (xDist == yDist) return false; //same diag
        }

        return true;
    }

    public static List<List<Integer>> totalNQueensBetter(int n) {
        List<List<Integer>> boards = new ArrayList<>();
        totalNQueensBetter(0, n, new ArrayList<>(), boards);
        return boards;
    }

    private static void totalNQueensBetter(int row, int n, List<Integer> board, List<List<Integer>> boards) {
        //Backtracking Case
        //Check if there is a conflict between last 2 queens
        /*if (board.size() > 1) {
            int prevQ = board.size() - 1;
            int earlierQ = prevQ - 1;
            if (board.get(prevQ) == board.get(earlierQ)) return; //same column
            int rowDist = Math.abs(prevQ - earlierQ);
            int colDist = Math.abs(board.get(prevQ) - board.get(earlierQ));
            if (rowDist == colDist) return; //same diag
        }*/

        //Base Case
        if (row == n) {
            boards.add(new ArrayList<>(board));
            return;
        }

        //Iterative Case
        for (int col = 0; col < n; col++) {
            if (isOk(board, row, col)) {
                board.add(col);
                totalNQueensBetter(row + 1, n, board, boards);
                board.remove(board.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueensBetter(4));
    }
}
