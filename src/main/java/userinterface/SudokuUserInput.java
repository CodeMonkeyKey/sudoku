package userinterface;

import interfaces.SudokuInput;

public record SudokuUserInput(int row, int col, int value) implements SudokuInput {
    @Override
    public int row() {
        return this.row;
    }

    @Override
    public int column() {
        return this.col;
    }

    @Override
    public int value() {
        return this.value;
    }
}
