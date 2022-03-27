import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    Scanner scanner;
    ArrayList<String> words = new ArrayList<>();
    Random rand = new Random();
    boolean playing = true;

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

        return words.get(rand.nextInt(words.size()));
    }



}
