public class Main {

    public static void main(String[] args) {
        Hangman game = new Hangman();

        game.getWords();
        game.welcomeScreen();
        game.getGameWord();
        System.out.println(game.secretWord);
        while(game.playing) {
            game.updateSecretWord();
            game.makeGuess();
            game.checkWin();
            System.out.println(game.secretWord);
        }

    }
}
