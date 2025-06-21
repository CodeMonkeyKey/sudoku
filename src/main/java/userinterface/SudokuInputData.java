package userinterface;

import interfaces.UserInput;

public record SudokuInputData(int row, int col, int value) implements UserInput {
    public SudokuInputData(int row, int col, int value) {
        this.row = Math.max(row, 0);
        this.col = Math.max(col, 0);
        this.value = Math.max(value, 0);
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.col;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
