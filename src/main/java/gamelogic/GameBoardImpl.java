package gamelogic;

import interfaces.GameBoard;
import java.util.Set;

public class GameBoardImpl implements GameBoard {
    public static final int DEFAULT_BOARD_SIZE = 9;
    public static final Set<Integer> availableSizes = Set.of(4, 9, 16);

    int[][] dataArray;
    private final int boardSize;

    GameBoardImpl(int boardSize, int[][] dataArray) throws RuntimeException {
        if (!availableSizes.contains(boardSize)) {
            throw new RuntimeException("Board size not available!!!");
        }
        if (dataArray.length != boardSize) {
            throw new RuntimeException("DataArray and boardSize does not match!!!");
        }
        for (int[] row: dataArray) {
            if (row.length != boardSize) {
                throw new RuntimeException("DataArray and boardSize does not match!!!");
            }
            for (int val: row) {
                if (val < 0 || val > boardSize) {
                    throw new RuntimeException("Invalid DataArray Values||");
                }
            }
        }
        this.boardSize = boardSize;
        this.dataArray = dataArray;
    }

    @Override
    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public int getValue(int row, int column) throws IndexOutOfBoundsException {
        if (row <= 0 || column <=0 || row > boardSize || column > boardSize) {
            throw new IndexOutOfBoundsException("The given row and column is out of bounds!!");
        }
        return dataArray[row-1][column-1];
    }

    @Override
    public void setValue(int row, int column, int value) throws RuntimeException  {
        if (row <= 0 || column <=0 || row > boardSize || column > boardSize) {
            throw new IndexOutOfBoundsException("The given row and column is out of bounds!!");
        }
        if (value <= 0 || value > boardSize) {
            throw new RuntimeException("The given input value is not allowed!!");
        }
        dataArray[row-1][column-1] = value;
    }


    @Override
    public int[][] getBoardAsArray() {
        int[][] boardCopy = new int[boardSize][boardSize];
        for (int row=0; row < boardSize; row++) {
            System.arraycopy(dataArray[row], 0, boardCopy[row], 0, boardSize);
        }
        return boardCopy;
    }
}
