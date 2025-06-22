package gamelogic;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class GameBoardTest {
    int validBoardSize = 4;
    int[][] validDataArray= {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
    };
    GameBoardImpl validGameBoard = new GameBoardImpl(validBoardSize, validDataArray);

    @Test(expected = RuntimeException.class)
    @Parameters(method = "provideInvalidInitData")
    public void initParamsNegativeTest(int boardSize, int[][] dataArray) {
        new GameBoardImpl(boardSize, dataArray);
    }

    private Object[] provideInvalidInitData() {
        return new Object[]{
                new Object[]{0, validDataArray},
                new Object[]{-1, validDataArray},
                new Object[]{validBoardSize+1, validDataArray},
                new Object[]{validBoardSize-1, validDataArray},
                new Object[]{validBoardSize, null},
                new Object[]{validBoardSize, new int[][] {{1}}},
                new Object[]{validBoardSize, new int[][] {{1, 2, 3, 4},
                                                          {1, 2, 3},
                                                          {1, 2, 3, 4},
                                                          {1, 2, 3, 4}}},
                new Object[]{validBoardSize, new int[][] {{1, -2, 3, 4},
                                                          {1, 2, 3, 4},
                                                          {1, 2, 3, 4},
                                                          {1, 2, 3, 4}}},
                new Object[]{validBoardSize, new int[][] {{1, 2, 3, 4},
                                                          {1, 2, 3, 4},
                                                          {1, 2, 5, 4},
                                                          {1, 2, 3, 4}}}
        };
    }

    @Test
    public void initParamsPositiveTest() {
        GameBoardImpl gameBoard = new GameBoardImpl(validBoardSize, validDataArray);
        Assert.assertNotNull(gameBoard);
        Assert.assertEquals(validBoardSize, gameBoard.getBoardSize());
        Assert.assertEquals(validDataArray, gameBoard.getBoardAsArray());
        Assert.assertNotSame(validDataArray, gameBoard.getBoardAsArray());
    }

    @Test
    @Parameters({"1, 1, 4",
                 "4, 4, 4",
                 "2, 3, 1"})
    public void setValuePositiveTest(int row, int col, int value) {
        validGameBoard.setValue(row, col, value);
        Assert.assertEquals(value, validGameBoard.getValue(row, col));
    }

    @Test(expected = RuntimeException.class)
    @Parameters({"0, 1, 4",
                 "1, 1, 5",
                 "-1, 3, 1",
                 "3, 2, -4",
                 " 2, 3, 0",
                 "3, 5, 1",
                 "5, 1, 2",
                 "2, 0, 4"})
    public void setValueNegativeTest(int row, int col, int value) {
        validGameBoard.setValue(row, col, value);
    }

    @Test(expected = RuntimeException.class)
    @Parameters({"0, 1",
                 "5, 3",
                 "1, -2",
                 "3, 6",
                 "5, 0"})
    public void getValueNegativeTest(int row, int col) {
        validGameBoard.getValue(row, col);
    }
}
