import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.manager.Game;
import ru.netology.manager.NotRegisteredException;

public class GameTest {

    Game players = new Game();
    Player player1 = new Player(1, "Petya", 2);
    Player player2 = new Player(11, "Vasya", 2);
    Player player3 = new Player(33, "Nastya", 5);


    @BeforeEach
    public void setup() {
        players.register("nik1", player1);
        players.register("nik2", player2);
        players.register("nik3", player3);
    }

    @Test
    public void shouldFindByName() {
        Player actual = players.findByName("Petya");
        Player expected = player1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundDraw() {
        int actual = players.round("Petya", "Vasya");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundFirstWinner() {
        int actual = players.round("Nastya", "Vasya");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundSecondWinner() {
        int actual = players.round("Petya", "Nastya");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRoundExistName() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Igor", "Valera");
        });
    }

    @Test
    public void shouldRoundExistNameSecond() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Petya", "Valera");
        });
    }

}
