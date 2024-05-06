import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testFirstWin() {
        Player player1 = new Player(1, "player1", 999);
        Player player2 = new Player(2, "player2", 1);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("player1", "player2"));
    }

    @Test
    public void testSecondWin() {
        Player player1 = new Player(1, "player1", 1);
        Player player2 = new Player(2, "player2", 999);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("player1", "player2"));
    }

    @Test
    public void testEqualRound() {
        Player player1 = new Player(1, "player1", 1);
        Player player2 = new Player(2, "player2", 1);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("player1", "player2"));
    }

    @Test
    public void testFirstNull() {
        Player player1 = new Player(1, "player1", 1);
        Player player2 = new Player(2, "player2", 1);

        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("player1", "player2")
        );
    }

    @Test
    public void testSecondNull() {
        Player player1 = new Player(1, "player1", 1);
        Player player2 = new Player(2, "player2", 1);

        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("player1", "player2")
        );
    }
}
