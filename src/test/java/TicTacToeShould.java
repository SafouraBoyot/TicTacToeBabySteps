import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeShould {
    @Test
    public void
    return_game_status(){
        TicTacToe ticTacToe = new TicTacToe();
        assertEquals(GameStatus.INPROGRESS,ticTacToe.gameStatus());
    }
}
