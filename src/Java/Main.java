public class Main {

    public static void main(String[] args) {
        Hangman game = new Hangman();

        game.getWords();
        game.welcomeScreen();
        game.getGameWord();
        System.out.println(game.hanging);
        while(game.playing) {
            game.printMissedLetters();
            game.updateSecretWord();
            game.makeGuess();
            game.checkWin();
        }

    }
}
