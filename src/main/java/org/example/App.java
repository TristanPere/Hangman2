package org.example;

import java.util.Scanner;
//import org.json.JSONArray;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Would You like to play a game of hangman? y/n");
        String newGame = scanner.nextLine();
        game.setPlayAgain(newGame);

        while (game.isPlayAgain()) {
            game.intialiseGame();
            while (game.getLives() > 0 && game.getCorrectGuesses() != 0) {
                System.out.println("Enter Guess:");
                String guess = scanner.nextLine();
                game.guessChar(guess);
            }
            game.gameOver();
            System.out.println("Would You like to play a game of hangman? y/n");
            newGame = scanner.nextLine();
            game.setPlayAgain(newGame);
        }
    }
}

