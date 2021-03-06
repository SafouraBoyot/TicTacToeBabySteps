import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
    private final List<String> board = new ArrayList<>();
    private String symbol;

    public Board() {
        this.symbol = "";
        for (int i = 0; i < 9; i++) {
            board.add(symbol);
        }
    }

    public int boardSize() {
        return board.size();
    }

    public void place(String symbol, int position) throws IllegalSymbolException, IllegalPositionException {
        this.symbol = symbol;
        if (hasNoSymbol() && symbol == "O")
            throw new IllegalSymbolException();
        if (board.get(position) != "") throw new IllegalPositionException();
        board.set(position, symbol);
    }


    public List<String> board() {

        return Collections.unmodifiableList(board);
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

    public String nextPlayer() {
        if (symbol == "X") return "O";
        else return "X";
    }

    public boolean hasWinner() {
        return checkHorizontalWinConditions()
                ||checkVerticalWinConditions()
                ||checkDiagonalWinConditions();
    }

    private boolean checkHorizontalWinConditions() {
        return !board.get(0).equals("") && !board.get(1).equals("") && !board.get(2).equals("") && (board.get(0).equals(board.get(1)) && board.get(1).equals(board.get(2)))
                || !board.get(3).equals("") && !board.get(4).equals("") && !board.get(5).equals("") && (board.get(3).equals(board.get(4)) && board.get(4).equals(board.get(5)))
                || !board.get(6).equals("") && !board.get(7).equals("") && !board.get(8).equals("") && (board.get(6).equals(board.get(7)) && board.get(7).equals(board.get(8)));
    }

    private boolean checkVerticalWinConditions() {
        return !board.get(0).equals("") && !board.get(3).equals("") && !board.get(6).equals("") && (board.get(0).equals(board.get(3)) && board.get(3).equals(board.get(6)))
                || !board.get(1).equals("") && !board.get(4).equals("") && !board.get(7).equals("") && (board.get(1).equals(board.get(4)) && board.get(4).equals(board.get(7)))
                || !board.get(2).equals("") && !board.get(5).equals("") && !board.get(8).equals("") && (board.get(2).equals(board.get(5)) && board.get(5).equals(board.get(8)));
    }

    private boolean checkDiagonalWinConditions() {
        return !board.get(0).equals("") && !board.get(4).equals("") && !board.get(8).equals("") && (board.get(0).equals(board.get(4)) && board.get(4).equals(board.get(8)))
                || !board.get(2).equals("") && !board.get(4).equals("") && !board.get(6).equals("") && (board.get(2).equals(board.get(4)) && board.get(4).equals(board.get(6)));
    }

    public boolean hasDraw() {

        for (String position: board) {
            if(position.equals(""))
                return false;
        }
        return true;

    }
}
