package userinterface;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SudokuUserInputTest {
    @Test
    @Parameters({"1, 1, 2",
                 "10, 12, 1",
                 "-1, 4, -2"})
    public void recordCreationTest(int row, int col, int value) {
        SudokuUserInput userInputData = new SudokuUserInput(row, col, value);
        assertEquals(row, userInputData.row());
        assertEquals(col, userInputData.column());
        assertEquals(value, userInputData.value());
    }
}
