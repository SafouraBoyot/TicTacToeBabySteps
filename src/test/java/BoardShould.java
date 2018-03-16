import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardShould {
    @Test public void
    has_nine_cells(){
        Board board = new Board();
        assertEquals(9,board.boardSize());
    }
}
