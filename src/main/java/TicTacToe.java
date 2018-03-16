public class TicTacToe {
    private Board board ;
    private String currentSymbol ;

    public TicTacToe(Board board) {
        this.board = board;
        this.currentSymbol = "X";
    }

    public  GameStatus gameStatus() {
        if(board.hasWinner()) return GameStatus.FINISHED;
        return GameStatus.INPROGRESS;
    }

    public void play(int position) throws IllegalSymbolException, IllegalPositionException {
        board.place(currentSymbol,position);
        this.currentSymbol = board.nextPlayer();

    }
}
