package com.king.SudokuPuzzleCreator.model;

/**
 *
 * Coordinates for Sudoku Puzzle:
 *
 *--------------------------------------------
 * | 0,0 0,1 0,2 | 0,3 0,4 0,5 | 0,6 0,7 0,8 |
 * | 1,0 1,1 1,2 | 1,3 1,4 1,5 | 1,6 1,7 1,8 |
 * | 2,0 2,1 2,2 | 2,3 2,4 2,5 | 2,6 2,7 2,8 |
 * |-------------|-------------|-------------|
 * | 3,0 3,1 3,2 | 3,3 3,4 3,5 | 3,6 3,7 3,8 |
 * | 4,0 4,1 4,2 | 4,3 4,4 4,5 | 4,6 4,7 4,8 |
 * | 5,0 5,1 5,2 | 5,3 5,4 5,5 | 5,6 5,7 5,8 |
 * |-------------|-------------|-------------|
 * | 6,0 6,1 6,2 | 6,3 6,4 6,5 | 6,6 6,7 6,8 |
 * | 7,0 7,1 7,2 | 7,3 7,4 7,5 | 7,6 7,7 7,8 |
 * | 8,0 8,1 8,2 | 8,3 8,4 8,5 | 8,6 8,7 8,8 |
 * ------------------------------------------|
 *
 * An example valid Sudoku Puzzle is:
 * -------------------------
 * | 5 1 3 | 2 6 8 | 4 9 7 |
 * | 2 4 6 | 9 5 7 | 1 8 3 |
 * | 7 9 8 | 1 4 3 | 5 6 2 |
 * |-------|-------|-------|
 * | 9 5 7 | 8 2 1 | 6 3 4 |
 * | 1 3 2 | 6 7 4 | 9 5 8 |
 * | 6 8 4 | 5 3 9 | 7 2 1 |
 * |-------|-------|-------|
 * | 4 2 9 | 3 1 6 | 8 7 5 |
 * | 3 6 1 | 7 8 5 | 2 4 9 |
 * | 8 7 5 | 4 9 2 | 3 1 6 |
 * -------------------------
 */
public class SudokuPuzzle {

    private final Integer[][] grid;

    public SudokuPuzzle(final Integer[][] grid) {
        this.grid = grid;
    }

    public SudokuPuzzle() {
        // Initialise a valid grid
        grid = new Integer[9][9];

    }

    public Integer[][] getGrid() {
        return grid;
    }

    public void prettyPrint() {
        System.out.println("-------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + grid[i][j]);
                if (j == 8) {
                    System.out.println(" |");
                }
                if (j == 2 || j == 5) {
                    System.out.print(" |");
                }
            }
            if (i == 2 || i == 5) {
                System.out.print("|-------|-------|-------|");
                System.out.println();
            }
            if (i == 8) {
                System.out.print("-------------------------");
            }
        }
    }
}
