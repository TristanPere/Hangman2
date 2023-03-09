package org.example;

public class GameUtils {
    public static String newLine = System.getProperty("line.separator");

     public static void ruleSet(){
        System.out.println(String.join(newLine, "HangMan:",
                "The aim of the game is to guess the unknown word.",
                "There is a blank line for each letter in the word.",
                "Each time you are prompted to guess a letter you may enter a letter.",
                "If you think you know the word you can enter the word!",
                "But be warned! If you enter the wrong word you loose the game!",
                "You have 8 live (chances to make the wrong guess)",
                "You win if you can guess all the correct letters or enter the correct word!",
                "Good luck:)"));
    }
}
