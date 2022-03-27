import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class HangmanTest {

    Hangman game;

    @BeforeEach
    void setup() {
        game = new Hangman();
    }

    @DisplayName("Tests that the game word is being pulled correctly")
    @Test
    void getGameWord() {
        game.getWords();
        int i = 0;
        while (i < 100) {
            assertTrue(game.words.contains(game.getGameWord()));
            i++;
        }

    }
}