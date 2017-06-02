package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by Miha on 06.05.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score;
    public int maxTile;

    private boolean isSaveNeeded = true;

    Stack<Tile[][]> previousStates = new Stack ( );
    Stack<Integer> previousScores = new Stack ( );

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list.size() == 0) return;
        if (list.size ( ) != 0) {
            list.get ((int) (list.size ( ) * Math.random ( ))).value = Math.random ( ) < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tileArrayList = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()){
                    tileArrayList.add(gameTiles[i][j]);
                }
            }
        }
        return tileArrayList;
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private boolean compressTiles(Tile[] tiles) {

        boolean change = false;
        for (int k = 0; k < tiles.length - 1; k++)
        {
            for (int i = 0; i < tiles.length - 1; i++)
            {
                if (tiles[i].isEmpty ( ) && !tiles[i + 1].isEmpty ( ))
                {
                    change = true;
                    tiles[i] = tiles[i + 1];
                    tiles[i + 1] = new Tile ( );
                }
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                change = true;
                tiles[i].value *= 2;
                tiles[i + 1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }
        return change;
    }

    private void rotateToRight()
    {
        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++)
        {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++)
            {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
            }
        }
    }


    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) || mergeTiles(gameTiles[i]))
                isChanged = true;
        }

        if (isChanged) addTile();

    }
    public void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }

    public void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }

    public void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles ( ).isEmpty ( ))
            return true;
        for (int i = 0; i < gameTiles.length; i++)
        {
            for (int j = 1; j < gameTiles.length; j++)
            {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++)
        {
            for (int j = 1; j < gameTiles.length; j++)
            {
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value)
                    return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {

        Tile[][] newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                newTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }

        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int)(Math.random() * 100)) % 4;

        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }
    
    public boolean hasBoardChanged() {
        return countTotalWeigh (gameTiles) - countTotalWeigh (previousStates.peek ( )) != 0;
    }

    private int countTotalWeigh(Tile[][] tiles) {
        int values = 0;
        for (Tile[] tile : tiles)
            for (Tile t : tile) values += t.value;

        return values;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        int emptyTiles = -1;
        int sc         = 0;
        if (hasBoardChanged ( ))
        {
            emptyTiles = getEmptyTiles ( ).size ( );
            sc = score;
        }
        rollback ( );
        return new MoveEfficiency (emptyTiles, sc, move);
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.poll().getMove().move();
    }
}
