package com.king.SudokuPuzzleCreator.relationship;

import com.king.SudokuPuzzleCreator.model.Coordinate;

import java.util.*;

public class GridRelationships {

    private static final List<Set<Coordinate>> BLOCK_COORDINATES;

    static {
        BLOCK_COORDINATES = new ArrayList<>();

        BLOCK_COORDINATES.add(addCoordinatesForBlock(0, 0));
        BLOCK_COORDINATES.add(addCoordinatesForBlock(0, 3));
        BLOCK_COORDINATES.add(addCoordinatesForBlock(0, 6));

        BLOCK_COORDINATES.add(addCoordinatesForBlock(3, 0));
        BLOCK_COORDINATES.add(addCoordinatesForBlock(3, 3));
        BLOCK_COORDINATES.add(addCoordinatesForBlock(3, 6));

        BLOCK_COORDINATES.add(addCoordinatesForBlock(6, 0));
        BLOCK_COORDINATES.add(addCoordinatesForBlock(6, 3));
        BLOCK_COORDINATES.add(addCoordinatesForBlock(6, 6));
    }

    private static Set<Coordinate> addCoordinatesForBlock(int startingX, int startingY) {
        Set<Coordinate> blockCoordinates = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blockCoordinates.add(new Coordinate(startingX + i, startingY + j));
            }
        }
        return blockCoordinates;
    }

    public static List<Set<Coordinate>> getBlockCoordinates() {
        return BLOCK_COORDINATES;
    }
}
