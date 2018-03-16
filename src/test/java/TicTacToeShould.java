import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeShould {
    @Test
    public void
    return_game_status(){
        Board board = new Board();
        TicTacToe ticTacToe = new TicTacToe(board);
        assertEquals(GameStatus.INPROGRESS,ticTacToe.gameStatus());
    }

    @Test
    public void
    return_game_status_if_game_is_finished_with_winner() throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        TicTacToe ticTacToe = new TicTacToe(board);

        ticTacToe.play(0);
        ticTacToe.play(3);
        ticTacToe.play(1);
        ticTacToe.play(4);
        ticTacToe.play(2);

        assertEquals(GameStatus.FINISHED,ticTacToe.gameStatus());
    }

    @Test
    public void
    return_game_status_if_game_is_a_draw() throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        TicTacToe ticTacToe = new TicTacToe(board);

        ticTacToe.play(0);
        ticTacToe.play(1);
        ticTacToe.play(2);
        ticTacToe.play(3);
        ticTacToe.play(4);
        ticTacToe.play(5);
        ticTacToe.play(7);
        ticTacToe.play(6);
        ticTacToe.play(8);

        assertEquals(GameStatus.FINISHED,ticTacToe.gameStatus());
    }
}
