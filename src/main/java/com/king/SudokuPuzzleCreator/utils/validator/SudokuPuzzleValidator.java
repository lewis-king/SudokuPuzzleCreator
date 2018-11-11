package com.king.SudokuPuzzleCreator.utils.validator;

import com.king.SudokuPuzzleCreator.model.SudokuPuzzle;
import com.king.SudokuPuzzleCreator.relationship.GridRelationships;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SudokuPuzzleValidator {

    public static boolean isValidAndCompletePuzzle(final SudokuPuzzle puzzle) {
        return isAValidGrid(puzzle.getGrid()) && isCompleteGrid(puzzle.getGrid());
    }

    public static boolean isAValidGrid(final Integer[][] gridArr) {

        // Validate Rows
        List<Integer[]> grid = asList(gridArr);
        Set<Integer> rowDuplicates = new HashSet<>();

        grid.forEach(numbersInRowArr -> {
            List<Integer> numbersInRow = asList(numbersInRowArr);
            rowDuplicates.addAll(numbersInRow.stream()
                    .filter(Objects::nonNull)
                    .filter(num -> Collections.frequency(numbersInRow, num) > 1)
                    .collect(Collectors.toSet()));
        });

        // Validate Columns
        // x = x coordinate y = y coordinate of grid
        Set<Integer> columnDuplicates = new HashSet<>();
        for (int y = 0; y < gridArr.length; y++) {
            List<Integer> numbersInColumn = new ArrayList<>();
            for (int x = 0; x < gridArr.length; x++) {
                numbersInColumn.add(gridArr[x][y]);
            }
            columnDuplicates.addAll(numbersInColumn.stream()
                    .filter(Objects::nonNull)
                    .filter(num -> Collections.frequency(numbersInColumn, num) > 1)
                    .collect(Collectors.toSet()));
        }


        // Validate Block
        // 0,0 0,1 0,2  0,3 0,4 0,5
        // 1,0 1,1 1,2  1,3 1,4 1,5
        // 2,0 2,1 2,2  2,3 2,4 2,5
        Set<Integer> blockDuplicates = new HashSet<>();
        List<Integer> numbersInBlock = new ArrayList<>();

        GridRelationships.getBlockCoordinates().forEach(blockCoordinates -> {
            blockCoordinates.forEach(blockCoordinate -> {
                numbersInBlock.add(gridArr[blockCoordinate.getX()][blockCoordinate.getY()]);
            });
            blockDuplicates.addAll(numbersInBlock.stream()
                        .filter(Objects::nonNull)
                    .filter(num -> Collections.frequency(numbersInBlock, num) > 1)
                    .collect(Collectors.toSet()));
            numbersInBlock.clear();
        });

        return rowDuplicates.isEmpty() && columnDuplicates.isEmpty() && blockDuplicates.isEmpty();
    }

    public static boolean isCompleteGrid(final Integer[][] gridArr) {
        List<Integer[]> grid = asList(gridArr);
        Set nulls = new HashSet<>();
        grid.forEach(numbersInRowArr -> {
            List<Integer> numbersInRow = asList(numbersInRowArr);
            nulls.addAll(numbersInRow.stream()
                    .filter(Objects::isNull)
                    .collect(Collectors.toSet()));
        });
        return nulls.isEmpty();
    }

}
