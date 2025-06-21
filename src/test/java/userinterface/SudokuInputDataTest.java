package userinterface;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SudokuInputDataTest {
    @Test
    @Parameters({"1, 1, 2",
                 "10, 12, 1"})
    public void positiveTest(int row, int col, int value) {
        SudokuInputData userInputData = new SudokuInputData(row, col, value);
        assertEquals(row, userInputData.getRow());
        assertEquals(col, userInputData.getColumn());
        assertEquals(value, userInputData.getValue());
    }

    @Test
    @Parameters({"5, 6, -1",
                 "0, 6, -4"})
    public void negativeTest(int row, int col, int value) {
        SudokuInputData userInputData = new SudokuInputData(row, col, value);
        assertEquals(Math.max(0, row), userInputData.getRow());
        assertEquals(Math.max(0, col), userInputData.getColumn());
        assertEquals(Math.max(0, value), userInputData.getValue());
    }
}
