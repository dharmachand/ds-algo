package datastructures.arrays.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /*
        Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        Note:

        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.

        Input: board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: true

     */

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> row, col, box;
        int br, bc;
        for (int r = 0; r < 9; r++) {
            row = new HashSet<>();
            col = new HashSet<>();
            box = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && !row.add(board[r][c])) return false;
                if (board[c][r] != '.' && !col.add(board[c][r])) return false;

                br = 3 * (r/3);
                bc = 3 * (r%3);
                if (board[br + c/3][bc + c%3] != '.' &&
                        !box.add(board[br + c/3][bc + c%3])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
