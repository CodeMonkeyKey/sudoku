package interfaces;

public interface GameValidator {
    boolean isValidMove(SudokuInput input);
    boolean boardStateIsValid();
}
