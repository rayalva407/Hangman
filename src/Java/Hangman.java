import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    Scanner scanner;
    Scanner input = new Scanner(System.in);
    ArrayList<String> words = new ArrayList<>();
    ArrayList<Character> playerGuesses = new ArrayList<>();
    Random rand = new Random();
    boolean playing = true;
    String secretWord;
    String guess;

    //This method gets the words from the words_alpha.txt and adds them to words array list
    public void getWords() {
        try {
            scanner = new Scanner(new File("src/words_alpha.txt"));
            while (this.scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Prints the Welcome Screen
    public void welcomeScreen() {
        System.out.println("Welcome to Hangman Game!");
        System.out.println();
    }

    //Gets the secret word from the words list that will be used for the current game
    public String getGameWord() {

        secretWord = words.get(rand.nextInt(words.size()));
        return secretWord;
    }

    public void updateHangingPost() {

    }

    //Updates the word with user's guesses
    public void updateSecretWord(String word) {
        for(int i =0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            }
            else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    public void makeGuess() {
        System.out.println("Guess a Letter Please");
        try {
            String guess = input.nextLine();
            playerGuesses.add(guess.charAt(0));
        } catch (Exception e) {
            System.out.println("Wrong input! Make sure to input one letter");
        }
    }



}
