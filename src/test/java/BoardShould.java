import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class BoardShould {


    @Test
    public void
    has_nine_cells() {
        Board board = new Board();
        assertEquals(9, board.boardSize());
    }

    @Test
    public void
    place_a_symbol_on_the_board() throws Exception {
        Board board = new Board();
        board.place("X", 0);
        assertEquals("X", board.board().get(0));
    }

    @Test(expected = IllegalSymbolException.class)
    public void
    place_O_as_a_first_player() throws Exception {
        Board board = new Board();
        board.place("O", 0);
    }


    @Test
    public void
    alternate_symbols() throws Exception {
        Board board = new Board();
        board.place("X", 1);

        assertEquals("O", board.nextPlayer());
    }

    @Test(expected = IllegalPositionException.class)
    public void
    not_allow_a_play_on_a_played_position() throws Exception {
        Board board = new Board();
        board.place("X", 0);
        board.place(board.nextPlayer(), 0);
    }

    @Test
    public void
    check_winning_first_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        board.place("X", 0);
        board.place("X", 1);
        board.place("X", 2);

        assertTrue(board.hasWinner());

    }

    @Test
    public void
    check_winning_second_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        board.place("X", 3);
        board.place("X", 4);
        board.place("X", 5);

        assertTrue(board.hasWinner());
    }

    @Test
    public void
    check_winning_third_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        board.place("X", 6);
        board.place("X", 7);
        board.place("X", 8);

        assertTrue(board.hasWinner());
    }

    @Test
    @Parameters({"0, 3 ,6"})
    public void
    check_winning_first_vertical_conditions(int one, int two, int three) throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        board.place("X", one);
        board.place("X", two);
        board.place("X", three);

        assertTrue(board.hasWinner());
    }

    @Test
    public void
    check_winning_diagonal_conditions() throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        board.place("X", 2);
        board.place("X", 4);
        board.place("X", 6);

        assertTrue(board.hasWinner());
    }

    @Test
    @Parameters({"0, 1 ,2, 3, 4, 5, 6, 7, 8"})
    public void
    check_draw_condition(
            int zero, int one, int two, int three,
            int four, int five, int six, int seven,
            int eight
    ) throws IllegalSymbolException, IllegalPositionException {
        Board board = new Board();
        board.place("X", zero);
        board.place("O", one);
        board.place("X", two);
        board.place("O", three);
        board.place("X", four);
        board.place("O", five);
        board.place("O", six);
        board.place("X", seven);
        board.place("O", eight);

        assertEquals(true, board.hasDraw());
    }
}