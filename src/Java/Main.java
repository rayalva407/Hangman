public class Main {

    public static void main(String[] args) {
        Hangman game1 = new Hangman();

        game1.getWords();
        game1.welcomeScreen();

        System.out.println(game1.getGameWord());
    }
}
