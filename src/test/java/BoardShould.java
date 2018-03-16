import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@RunWith(JUnitParamsRunner.class)
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
    check_winning_first_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        board.place("X", 0);
        board.place("X", 1);
        board.place("X", 2);

        assertTrue(board.hasWinner());

    }

    @Test public void
    check_winning_second_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        board.place("X", 3);
        board.place("X", 4);
        board.place("X", 5);

        assertTrue(board.hasWinner());
    }

    @Test public void
    check_winning_third_horizontal_conditions() throws IllegalSymbolException, IllegalPositionException {
        board.place("X", 6);
        board.place("X", 7);
        board.place("X", 8);

        assertTrue(board.hasWinner());
    }

    @Test
    @Parameters({"0, 3 ,6"})
    public void
    check_winning_first_vertical_conditions(int one,int two,int three) throws IllegalSymbolException, IllegalPositionException {
        board.place("X", one);
        board.place("X", two);
        board.place("X", three);

        assertTrue(board.hasWinner());
    }

    @Test
    @Parameters({"0, 4 ,8", "2, 4, 6"})
    public void
    check_winning_diagonal_conditions(int one,int two,int three) throws IllegalSymbolException, IllegalPositionException {
        board.place("X", one);
        board.place("X", two);
        board.place("X", three);
        
        assertTrue(board.hasWinner());
    }

    @Test public void
    check_draw_condition() throws IllegalSymbolException, IllegalPositionException {
        board.place("X", 0);
        board.place("O", 1);
        board.place("X", 2);
        board.place("O", 3);
        board.place("X", 4);
        board.place("O", 5);
        board.place("O", 6);
        board.place("X", 7);
        board.place("O", 8);

        assertTrue(board.hasDraw());
    }
}