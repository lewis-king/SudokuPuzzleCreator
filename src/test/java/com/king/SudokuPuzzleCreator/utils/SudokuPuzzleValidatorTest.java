package com.king.SudokuPuzzleCreator.utils;

import com.king.SudokuPuzzleCreator.utils.validator.SudokuPuzzleValidator;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SudokuPuzzleValidatorTest {

    @Test
    public void shouldBeAnIncompletePuzzleWhenMissingElements() {
        //Given
        Integer[][] grid = new Integer[9][9];
        grid[0][0] = 1;

        //When
        boolean actual = SudokuPuzzleValidator.isCompleteGrid(grid);
        //Then
        assertThat(actual, is(false));
    }

    @Test
    public void shouldBeAValidPuzzleWhenPopulatedCorrectly() {
        //Given
        Integer[][] grid = dummyValidGrid();

        //When
        boolean actual = SudokuPuzzleValidator.isAValidGrid(grid);
        //Then
        assertThat(actual, is(true));
    }

    @Test
    public void shouldBeAnInvalidPuzzleWhenBlockContainsSameNumber() {
        //Given
        Integer[][] grid = new Integer[9][9];
        grid[0][0] = 1;
        grid[2][2] = 1;

        //When
        boolean actual = SudokuPuzzleValidator.isAValidGrid(grid);
        //Then
        assertThat(actual, is(false));
    }

    @Test
    public void shouldBeAnInvalidPuzzleWhenAGridRowContainsTheSameNumber() {
        //Given
        Integer[][] grid = new Integer[9][9];
        grid[0][0] = 1;
        grid[0][6] = 1;

        //When
        boolean actual = SudokuPuzzleValidator.isAValidGrid(grid);
        //Then
        assertThat(actual, is(false));
    }

    @Test
    public void shouldBeAnInvalidPuzzleWhenAGridColumnContainsTheSameNumber() {
        //Given
        Integer[][] grid = new Integer[9][9];
        grid[1][1] = 1;
        grid[3][1] = 1;

        //When
        boolean actual = SudokuPuzzleValidator.isAValidGrid(grid);
        //Then
        assertThat(actual, is(false));
    }

    @Test
    public void shouldBeACompletelyPopulatedSudokuPuzzle() {
        //Given
        Integer[][] grid = dummyValidGrid();

        //When
        boolean actual = SudokuPuzzleValidator.isCompleteGrid(grid);

        //Then
        assertThat(actual, is(true));
    }

    private Integer[][] dummyValidGrid() {
        Integer[][] grid = new Integer[9][9];

        grid[0][0] = 1; grid[0][1] = 2; grid[0][2] = 3; grid[0][3] = 4; grid[0][4] = 5; grid[0][5] = 6; grid[0][6] = 7; grid[0][7] = 8; grid[0][8] = 9;
        grid[1][0] = 4; grid[1][1] = 5; grid[1][2] = 6; grid[1][3] = 7; grid[1][4] = 8; grid[1][5] = 9; grid[1][6] = 1; grid[1][7] = 2; grid[1][8] = 3;
        grid[2][0] = 7; grid[2][1] = 8; grid[2][2] = 9; grid[2][3] = 1; grid[2][4] = 2; grid[2][5] = 3; grid[2][6] = 4; grid[2][7] = 5; grid[2][8] = 6;
        grid[3][0] = 2; grid[3][1] = 3; grid[3][2] = 4; grid[3][3] = 5; grid[3][4] = 6; grid[3][5] = 7; grid[3][6] = 8; grid[3][7] = 9; grid[3][8] = 1;
        grid[4][0] = 5; grid[4][1] = 6; grid[4][2] = 7; grid[4][3] = 8; grid[4][4] = 9; grid[4][5] = 1; grid[4][6] = 2; grid[4][7] = 3; grid[4][8] = 4;
        grid[5][0] = 8; grid[5][1] = 9; grid[5][2] = 1; grid[5][3] = 2; grid[5][4] = 3; grid[5][5] = 4; grid[5][6] = 5; grid[5][7] = 6; grid[5][8] = 7;
        grid[6][0] = 3; grid[6][1] = 4; grid[6][2] = 5; grid[6][3] = 6; grid[6][4] = 7; grid[6][5] = 8; grid[6][6] = 9; grid[6][7] = 1; grid[6][8] = 2;
        grid[7][0] = 6; grid[7][1] = 7; grid[7][2] = 8; grid[7][3] = 9; grid[7][4] = 1; grid[7][5] = 2; grid[7][6] = 3; grid[7][7] = 4; grid[7][8] = 5;
        grid[8][0] = 9; grid[8][1] = 1; grid[8][2] = 2; grid[8][3] = 3; grid[8][4] = 4; grid[8][5] = 5; grid[8][6] = 6; grid[8][7] = 7; grid[8][8] = 8;

        return grid;
    }
}