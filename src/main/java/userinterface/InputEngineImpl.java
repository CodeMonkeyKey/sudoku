package userinterface;

import interfaces.InputEngine;
import interfaces.SudokuInput;

public class InputEngineImpl implements InputEngine {
    @Override
    public SudokuInput getUserInput() {
        return new SudokuUserInput(0, 0, 0);
    }
}
