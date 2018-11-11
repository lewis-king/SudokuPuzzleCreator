package com.king.SudokuPuzzleCreator.utils;

import com.king.SudokuPuzzleCreator.model.SudokuPuzzle;
import com.king.SudokuPuzzleCreator.utils.generator.SudokuPuzzleGenerator;
import com.king.SudokuPuzzleCreator.utils.validator.SudokuPuzzleValidator;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SudokuPuzzleGeneratorTest {



    @Test
    public void testPuzzleSize() throws InterruptedException {
        //Given
        int expected = 81;
        //When
        SudokuPuzzle result = SudokuPuzzleGenerator.generatePuzzle(0);
        //Then
        assertThat(SudokuPuzzleValidator.isValidAndCompletePuzzle(result), is(true));
    }

}