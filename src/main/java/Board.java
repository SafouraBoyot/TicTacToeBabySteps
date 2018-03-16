
public class Board {
    private String [] board  = new String [9];
    public  int boardSize() {
        return board.length ;
    }

    public void place(String symbol, int position) throws IllegalSymbolException {
        for (String p : board) {
            if (p != null && symbol == "O") throw new IllegalSymbolException();
        }

        board[position] = symbol;
    }

    public String[] board() {
        return board;
    }
}
