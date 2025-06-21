package userinterface;

import interfaces.UserInput;

public record UserInputData(int row, int col, int value) implements UserInput {
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
