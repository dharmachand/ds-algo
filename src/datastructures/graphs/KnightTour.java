package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightTour {
    /*
     * Complete the function below.
     */
    static int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {

        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> q = new LinkedList<>();
        Cell startCell = new Cell(start_row, start_col);
        Cell endCell = new Cell(end_row, end_col);
        q.offer(startCell); //starting cell of knight
        visited[startCell.row][startCell.col] = true;

        Cell currCell;
        while (!q.isEmpty()) {
            currCell = q.poll();

            if (currCell.equals(endCell)) return currCell.moves;

            List<Cell> neighbors = getNeighbors(rows, cols, currCell);
            for (Cell neighbor : neighbors) {
                if (!visited[neighbor.row][neighbor.col]) {
                    visited[neighbor.row][neighbor.col] = true;
                    neighbor.moves = currCell.moves + 1;
                    q.offer(neighbor);
                }
            }
        }

        return -1;
    }

    static List<Cell> getNeighbors(int rows, int cols, Cell currCell) {
        List<Cell> neighbors = new ArrayList<>();
        //Knight moves in L shape
        //if its in the middle there will be 8 moves
        int row = currCell.row;
        int col = currCell.col;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols) neighbors.add(new Cell(newRow, newCol));
        }

        return neighbors;
    }

    static class Cell {
        int row;
        int col;
        int moves;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell that = (Cell) o;
            return this.row == that.row && this.col == that.col;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println(find_minimum_number_of_moves(5,5, 0, 0, 4, 1));
    }
}
