import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<String> board = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 9; i++) {
            board.add("");
        }
    }

    public int boardSize() {
        return board.size();
    }

    public void place(String symbol, int position) throws IllegalSymbolException {

        if (hasNoSymbol() && symbol == "O")
            throw new IllegalSymbolException();

        board.add(position, symbol);
    }

    public List<String> board() {
        return board;
    }

    private boolean hasNoSymbol() {
        for (String pos : board) {
            if (pos != "") return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        return board != null ? board.equals(board1.board) : board1.board == null;
    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }
}
