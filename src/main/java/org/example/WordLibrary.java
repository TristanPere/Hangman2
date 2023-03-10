package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class WordLibrary {
    private JSONParser parser = new JSONParser();
    private JSONArray wordArr;

    {
        try {
            Object wordObj = parser.parse(new FileReader("C:\\Users\\trist\\Documents\\Development\\05-java\\Hangman2\\src\\main\\java\\org\\example\\wordlist.json"));
            wordArr = (JSONArray) wordObj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String randomWord() {
        int randomIndex = (int) (Math.random() * wordArr.size());
        String word = (String) wordArr.get(randomIndex);
            if (word.length() <= 5) {
                word = randomWord();
            }
        return word;
    }

}
