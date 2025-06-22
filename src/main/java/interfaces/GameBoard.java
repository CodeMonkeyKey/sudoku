package interfaces;

public interface GameBoard {
    int getValue(int row, int column);
    void setValue(int row, int column, int value);
    int getBoardSize();
    Integer[][] getBoardAsArray();
}
