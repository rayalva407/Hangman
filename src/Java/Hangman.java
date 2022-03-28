import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    Scanner scanner;
    Scanner input = new Scanner(System.in);
    ArrayList<String> words = new ArrayList<>();
    HashSet<Character> playerGuesses = new HashSet<>();
    HashSet<Character> missedLetters = new HashSet<>();
    Random rand = new Random();
    boolean playing = true;
    String secretWord;
    String playAgain;


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

    public void printMissedLetters() {
        System.out.print("Missed Letters: ");
        for (char c : missedLetters) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    //Updates the word with user's guesses
    public void updateSecretWord() {

        for(int i =0; i < secretWord.length(); i++) {
            if (playerGuesses.contains(secretWord.charAt(i))) {
                System.out.print(secretWord.charAt(i));
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
            if (playerGuesses.contains(guess.charAt(0))) {
                System.out.println("You have already guessed this letter try again.");
                makeGuess();
            }
            if (!secretWord.contains(Character.toString(guess.charAt(0)))) {
                missedLetters.add(guess.charAt(0));
            }
            playerGuesses.add(guess.charAt(0));
        } catch (Exception e) {
            System.out.println("Wrong input! Make sure to input one letter");
        }
    }

    public void checkWin() {
        int correctCount = 0;

        for (int i =0; i < secretWord.length(); i++) {
            if (playerGuesses.contains(secretWord.charAt(i))) {
                correctCount++;
            }
        }
        if (correctCount == secretWord.length()) {
            System.out.println("Correct! The secret word is " + secretWord + "! You have won!");
            System.out.println("Would you like to play again? (yes or no)");
            playAgain = input.nextLine();
            if (playAgain.equals("no")) {
                System.out.println("Thanks for playing! Goodbye!");
                playing = false;
            }
            if (playAgain.equals("yes")) {
                getGameWord();
                playerGuesses.clear();
            }
        }
    }




}
