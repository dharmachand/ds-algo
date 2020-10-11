package algorithms.backtracking;

import java.util.Arrays;

public class SolveSudoku {
    /*
        Write a program to solve a Sudoku puzzle by filling the empty cells.

        A sudoku solution must satisfy all of the following rules:

        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
        The '.' character indicates empty cells.
        Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
        Explanation: The input board is shown above and the only valid solution is shown below:
    */

    public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, r, c, ch)) {
                            board[r][c] = ch;
                            if (solve(board)) return true; //board solved
                            else board[r][c] = '.'; //backtrack and keep solving
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) { //validate row & col
            if (board[row][i] != '.' && board[row][i] == ch) return false;
            if (board[i][col] != '.' && board[i][col] == ch) return false;
        }

        //validate 3x3 box
        int br = 3*(row/3);
        int bc = 3*(col/3);
        for (int r = br; r < br + 3; r++) {
            for (int c = bc; c < bc + 3; c++) {
                if (board[r][c] != '.' && board[r][c] == ch) return false;
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
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
