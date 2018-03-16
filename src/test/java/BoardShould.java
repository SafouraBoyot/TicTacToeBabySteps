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
}