public class Board {
    private String [] board  = new String [9];
    public  int boardSize() {
        return board.length ;
    }

    public void place(String symbol, int position) {
        board[position] = symbol;
    }

    public String[] board() {
        return board;
    }
}
