package gamelogic;

import interfaces.GameBoard;
import interfaces.PuzzleGenerator;

import static gamelogic.GameBoardImpl.DEFAULT_BOARD_SIZE;
import static gamelogic.GameBoardImpl.availableSizes;

public class PuzzleGeneratorImpl implements PuzzleGenerator {
    private final int boardSize;

    PuzzleGeneratorImpl() {
        boardSize = DEFAULT_BOARD_SIZE;
    }

    PuzzleGeneratorImpl(int boardSize) throws RuntimeException  {
        if (!availableSizes.contains(boardSize)) {
            throw new RuntimeException("Board size not available!!!");
        }
        this.boardSize = boardSize;
    }

    @Override
    public GameBoard generateBoard(){
        int[][] gameBoard = new int[boardSize][boardSize];
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                gameBoard[i][j] = j;
            }
        }
        return new GameBoardImpl(boardSize, gameBoard);
    }
}
