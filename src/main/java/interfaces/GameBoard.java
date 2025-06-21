package interfaces;

import java.util.List;

public interface GameBoard {
    Integer getValue(int row, int column);
    List<Integer> getRow(int row);
    List<Integer> getColumn(int column);
}
