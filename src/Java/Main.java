public class Main {

    public static void main(String[] args) {
        Hangman game = new Hangman();

        game.getWords();
        game.welcomeScreen();
        game.getGameWord();

        while(game.playing) {
            game.updateSecretWord(game.secretWord);
            System.out.println(game.secretWord);
            game.makeGuess();
            game.updateSecretWord(game.secretWord);
        }

    }
}
