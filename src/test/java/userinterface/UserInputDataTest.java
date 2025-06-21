package userinterface;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class UserInputDataTest {
    @Test
    @Parameters({"0, 0, 0",
                 "1, 1, 2"})
    public void positiveTest(int row, int col, int value) {
        UserInputData userInputData = new UserInputData(row, col, value);
        assertEquals(row, userInputData.getRow());
        assertEquals(col, userInputData.getColumn());
        assertEquals(value, userInputData.getValue());
    }
}
