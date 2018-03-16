import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardShould {
    private Board board;

    @Before
    public void initialise() {
        board = new Board();
    }

    @Test
    public void
    has_nine_cells() {
        assertEquals(9, board.boardSize());
    }

    @Test
    public void
    place_a_symbol_on_the_board() throws Exception {
        board.place("X", 0);

        assertEquals("X", board.board().get(0));
    }

    @Test(expected = IllegalSymbolException.class)
    public void
    place_O_as_a_first_player() throws Exception {
        board.place("O", 0);
    }


    @Test public void
    alternate_symbols() throws Exception {
        board.place("X",1);

        assertEquals("O",board.nextPlayer());
    }

    @Test(expected = IllegalPositionException.class)
    public void
    not_allow_a_play_on_a_played_position() throws Exception {
        board.place("X", 0);
        board.place(board.nextPlayer(), 0);
    }

    @Test public void
    check_winning_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        board.place("X", 0);
        board.place("X", 1);
        board.place("X", 2);

        assertTrue(board.hasWinner());
    }
}