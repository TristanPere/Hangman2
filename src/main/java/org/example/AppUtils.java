package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.example.GameUtils.getUserName;
import static org.example.PlayerDataUtils.*;
import static org.example.PlayerUtils.*;

public class AppUtils {
    public static String newLine = System.getProperty("line.separator");

    public static Scanner Scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static void ruleSet() {
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

    public static int nextID() {
        int id = getNumOfUsers() + 1;
        return id;
    }
    public static boolean isAnInteger(String stringNumber) {
        boolean valid = false;
        try {
            Integer.parseInt(stringNumber);
            valid = true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return valid;
    }

    private static JSONParser parser = new JSONParser();

    public static JSONArray readFromJSON() {
        JSONArray playerArr = new JSONArray();
        try {
            Object playerArrObj = parser.parse(new FileReader("C:\\Users\\trist\\Documents\\Development\\05-java\\Hangman2\\src\\main\\java\\org\\example\\PlayerData.json"));
            playerArr = (JSONArray) playerArrObj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return playerArr;
    }

    public static void writeToJSON(JSONObject playerObj) {
        JSONArray playerArr;
        try {
            Object playerArrObj = parser.parse(new FileReader("C:\\Users\\trist\\Documents\\Development\\05-java\\Hangman2\\src\\main\\java\\org\\example\\PlayerData.json"));
            playerArr = (JSONArray) playerArrObj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        playerArr.add(playerObj);
        try {
            FileWriter file = new FileWriter("C:\\Users\\trist\\Documents\\Development\\05-java\\Hangman2\\src\\main\\java\\org\\example\\PlayerData.json");
            file.write(playerArr.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: User Saved");
    }
    public static void updateJSON(int id){
        JSONArray playerArr;
        try {
            Object playerArrObj = parser.parse(new FileReader("C:\\Users\\trist\\Documents\\Development\\05-java\\Hangman2\\src\\main\\java\\org\\example\\PlayerData.json"));
            playerArr = (JSONArray) playerArrObj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        playerArr.set(id,buildPlayerObj(getUserName(), getPlayerScore(getUserName()), getPlayerId(getUserName())));
        try {
            FileWriter file = new FileWriter("C:\\Users\\trist\\Documents\\Development\\05-java\\Hangman2\\src\\main\\java\\org\\example\\PlayerData.json");
            file.write(playerArr.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: User Saved");
    }
}
