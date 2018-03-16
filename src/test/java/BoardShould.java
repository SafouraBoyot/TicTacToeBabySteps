import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardShould {
    @Test
    public void
    has_nine_cells() {
        Board board = new Board();
        assertEquals(9, board.boardSize());
    }

    @Test
    public void
    place_a_symbol_on_the_board() throws IllegalSymbolException {
        Board board = new Board();

        board.place("X", 0);

        assertEquals("X", board.board().get(0));
    }

    @Test(expected = IllegalSymbolException.class)
    public void
    place_O_as_a_first_player() throws IllegalSymbolException {
        Board board = new Board();


        board.place("O", 0);
    }


    @Test public void
    alternate_symbols() throws IllegalSymbolException {
        Board board =new Board();
        board.place("X",1);

        assertEquals("O",board.nextPlayer());
    }

    @Test(expected = IllegalPositionException.class) public void
    not_allow_a_play_on_a_played_position() throws IllegalSymbolException {
        Board board = new Board();

        board.place("X", 0);
        board.place(board.nextPlayer(), 0);
    }
}