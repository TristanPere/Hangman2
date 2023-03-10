package org.example;

import static org.example.AppUtils.*;
import static org.example.GameUtils.*;
import static org.example.PlayerUtils.*;

public class Game {
    private String word;

    private String[] solutionCharArr;

    private String[] guessedDashArr;

    private String[] usedCharArr;

    private int correctGuesses;

    private int guessNum;

    private Player player;

    private boolean playAgain;

    public Game() {
        playAgain = true;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(String newGame) {
        if (newGame.toUpperCase().matches("Y")) {
            this.playAgain = true;
        } else if (newGame.toUpperCase().matches("N")) {
            System.out.println("Thank You for Playing");
            this.playAgain = false;
        } else {
            System.out.println("Input unknown. GameOver.");
            this.playAgain = false;
        }
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }

    public String getWord() {
        return word;
    }

    public int getLives() {
        return player.getLives();
    }

    public String getGuessedDashArr() {
        return String.join(" ", guessedDashArr);
    }

    public String getUsedCharArr() {
        int i = 0;
        while (usedCharArr[i] != null) {
            i++;
        }
        String[] cleanArr = new String[i];
        System.arraycopy(usedCharArr, 0, cleanArr, 0, i);
        return String.join(",", cleanArr);
    }

    public void intialiseGame() {
        WordLibrary wordLibrary = new WordLibrary();
        this.word = wordLibrary.randomWord();
        this.solutionCharArr = word.toUpperCase().split("");
        this.guessedDashArr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.guessedDashArr[i] = "_";
        }
        this.correctGuesses = word.length();
        System.out.println(String.join(newLine,
                "You have 8 lives to guess the correct letters and word.",
                "Press # at any point to view the rules",
                getGuessedDashArr()));
        this.usedCharArr = new String[50];
        this.guessNum = 0;
        this.player.setLives();
    }

    public void intialiseGame(String playerName) {
        WordLibrary wordLibrary = new WordLibrary();
        this.word = wordLibrary.randomWord();
        this.solutionCharArr = word.toUpperCase().split("");
        this.guessedDashArr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.guessedDashArr[i] = "_";
        }
        this.correctGuesses = word.length();
        System.out.println(String.join(newLine,
                "Welcome to Hangman " + playerName + ".",
                "You have 8 lives to guess the correct letters and word.",
                "Press # at any point to view the rules",
                getGuessedDashArr()));
        this.usedCharArr = new String[26];
        this.guessNum = 0;
    }
    public void initialisePlayer(String playerName){
        this.player = new Player(playerName);
        this.player.setScore(getPlayerScore(playerName));
    }
    public void gameOver() {
        if(isNewUser()){
            writeToJSON(buildPlayerObj(player.getName(), player.getScore()));
        } else {
            updateJSON(getPlayerId(player.getName()));
        }
        if (player.getLives() == 0) {
            System.out.println(String.join(newLine, player.getName() + ": You loose",
                    "The word was: " + getWord().toUpperCase(),
                    "Current Score: " + player.getScore()));
        } else {
            System.out.println(String.join(newLine, "Well done " + player.getName() + " you win!",
                    "Current Score: " + player.getScore()));
        }
    }

    private String successfulGuessMessage(boolean successful, String guess) {

        PictureArr hangManGallows = new PictureArr();
        if (successful) {
            return String.join(newLine,
                    guess + ": Is a Correct letter",
                    "Working Solution: " + getGuessedDashArr(),
                    "Guessed Characters: " + getUsedCharArr(),
                    "Lives left: " + player.getLives());
        } else {
            return String.join(newLine,
                    hangManGallows.getHangMan(player.getLives()),
                    guess + ": Is not a Correct letter",
                    "Working Solution: " + getGuessedDashArr(),
                    "Guessed Characters: " + getUsedCharArr(),
                    "Lives left: " + player.getLives()
            );
        }
    }

    private String successfulWordGuessMessage(boolean successful, String guess) {

        PictureArr hangManGallows = new PictureArr();
        if (successful) {
            return String.join(newLine,
                    guess + ": Is the Correct Word!",
                    "Lives left: " + player.getLives(),
                    "Current Score: " + player.getScore());
        } else {
            return String.join(newLine,
                    hangManGallows.getHangMan(player.getLives()),
                    guess + ": Is Not the Correct Word",
                    "Lives left: " + player.getLives(),
                    "Current Score: " + player.getScore());
        }
    }

    private boolean charCheck(String guessChar) {
        if (getUsedCharArr().contains(guessChar.toUpperCase())) {
            System.out.println(String.join(newLine,
                    guessChar.toUpperCase() + " has already been guessed. Please enter a new letter:",
                    "Working Solution: " + getGuessedDashArr(),
                    "Guessed Characters: " + getUsedCharArr(),
                    "Lives left: " + player.getLives()));
            return false;
        } else if (guessChar.matches("#")) {
            ruleSet();
            return false;
        } else if (!guessChar.matches("[a-zA-Z]+")) {
            System.out.println(String.join(newLine,
                    guessChar.toUpperCase() + " is not a letter. Please Guess Letters Only.",
                    "Working Solution: " + getGuessedDashArr(),
                    "Guessed Characters: " + getUsedCharArr(),
                    "Lives left: " + player.getLives()));
            return false;
        } else if (guessChar.length() > 1 && guessChar.length() < 5) {
            System.out.println(String.join(newLine,
                    guessChar.toUpperCase() + " is Not One letter.",
                    "Please Guess One letter at A Time or The Whole Word.",
                    "Working Solution: " + getGuessedDashArr(),
                    "Guessed Characters: " + getUsedCharArr(),
                    "Lives left: " + player.getLives()));
            return false;
        } else {
            return true;
        }
    }

    public void guessChar(String guessChar) {
        boolean valid = charCheck(guessChar);
        if (valid) {
            if (word.toUpperCase().matches(guessChar.toUpperCase())) {
                System.out.println(successfulWordGuessMessage(true, guessChar.toUpperCase()));
                for (int i = 0; i < correctGuesses + 5; i++) {
                    player.setScore();
                }
                this.correctGuesses = 0;
            } else if (word.toUpperCase().contains(guessChar.toUpperCase())) {
                int count = 0;
                for (String s : solutionCharArr) {
                    if (s.equals(guessChar.toUpperCase())) {
                        count++;
                    }
                }
                int[] index = new int[count];
                count = 0;
                for (int i = 0; i < solutionCharArr.length; i++) {
                    if (solutionCharArr[i].equals(guessChar.toUpperCase())) {
                        index[count] = i;
                        count++;
                    }
                }
                for (int j : index) {
                    guessedDashArr[j] = guessChar.toUpperCase();
                }
                usedCharArr[guessNum] = guessChar.toUpperCase();
                this.guessNum++;
                player.setScore();
                this.correctGuesses -= count;
                System.out.println(successfulGuessMessage(true, guessChar.toUpperCase()));
            } else if (!word.toUpperCase().contains(guessChar.toUpperCase()) && guessChar.length() == 1) {
                this.player.looseLife();
                usedCharArr[guessNum] = guessChar.toUpperCase();
                this.guessNum++;
                System.out.println(successfulGuessMessage(false, guessChar.toUpperCase()));
            } else if (guessChar.length() == word.length()) {
                this.player.looseEverything();
                System.out.println(successfulWordGuessMessage(false, guessChar.toUpperCase()));
            } else {
                System.out.println("Please only enter 1 letter or a word of the same number of characters for a guess");
                this.player.looseLife();
                System.out.println("Lives left: " + player.getLives());
            }
        }
    }

}

