package com.javarush.task.task35.task3513;

/**
 * Created by Miha on 06.05.2017.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }


    @Override
    public int compareTo(MoveEfficiency efficiency) {
        int compareResult = Integer.compare(numberOfEmptyTiles, efficiency.numberOfEmptyTiles);

        if (compareResult == 0) compareResult = Integer.compare(score, efficiency.score);

        return compareResult;
    }
}
