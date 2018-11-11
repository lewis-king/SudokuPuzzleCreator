package com.king.SudokuPuzzleCreator.utils.generator;

import com.king.SudokuPuzzleCreator.model.SudokuPuzzle;
import com.king.SudokuPuzzleCreator.utils.validator.SudokuPuzzleValidator;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SudokuPuzzleGenerator {

    public static SudokuPuzzle generatePuzzle(final int delay) throws InterruptedException {
        final Integer[][] grid = new Integer[9][9];
        Map<Integer, Set<Integer>> exhaustedNums = new HashMap<>();
        int position = 0;
        Integer currentPlacedNum = null;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                position++;
                boolean validPlacement = false;
                Set<Integer> triedNumbers = exhaustedNums.get(position);
                if (triedNumbers == null) {
                    triedNumbers = new HashSet<>();
                }
                while (!validPlacement) {
                    int randomNum = getRandomIntValBetweenZeroAndEight(triedNumbers);
                    grid[i][j] = randomNum;
                    triedNumbers.add(randomNum);
                    exhaustedNums.put(position, triedNumbers);
                    validPlacement = SudokuPuzzleValidator.isAValidGrid(grid);
                    new SudokuPuzzle(grid).prettyPrint();
                    if (delay != 0) {
                        Thread.sleep(delay);
                    }
                    if ((triedNumbers.size() == 9)
                            || (!validPlacement && triedNumbers.size() == 9
                            && (((currentPlacedNum != null && currentPlacedNum == randomNum)
                            || (currentPlacedNum == null))))) {
                        grid[i][j] = null;
                        if (j == 0) {
                            i--;
                            j = 7;
                            currentPlacedNum = grid[i + 1][j + 1];
                        } else {
                            j -= 2;
                            currentPlacedNum = grid[i][j + 1];
                        }
                        exhaustedNums.put(position, null);
                        position -=2;
                        break;
                    }
                }

            }
        }
        SudokuPuzzle sudokuPuzzle = new SudokuPuzzle(grid);
        return sudokuPuzzle;
    }

    private static int getRandomIntValBetweenZeroAndEight(Set<Integer> triedNumbers) {
        int generatedRandom = 1;
        if (triedNumbers.size() != 9) {
            boolean isNewNum = false;
            while (!isNewNum) {
                generatedRandom = ThreadLocalRandom.current().nextInt(1, 9 + 1);
                isNewNum = !triedNumbers.contains(generatedRandom);
            }
        }
        return generatedRandom;
    }

}
