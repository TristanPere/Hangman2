package org.example;


import static org.example.AppUtils.*;
import static org.example.GameUtils.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Login With Username (1) | Login as New User (2)");
        String loginType = Scanner().nextLine();
        if (isAnInteger(loginType)) {
            loginCheck(Integer.parseInt(loginType));
        } else {
            loginCheck(3);
        }
        game.initialisePlayer(getUserName());
        while (game.isPlayAgain()) {
            game.intialiseGame();
            while (game.getLives() > 0 && game.getCorrectGuesses() != 0) {
                System.out.println("Enter Guess:");
                String guess = Scanner().nextLine();
                game.guessChar(guess);
            }
            game.gameOver();
            System.out.println("Would You like to play another game of hangman? y/n");
            String newGame = Scanner().nextLine();
            game.setPlayAgain(newGame);
        }
    }
}

