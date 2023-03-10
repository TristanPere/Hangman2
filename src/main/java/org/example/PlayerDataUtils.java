package org.example;

import org.json.simple.JSONArray;

import static org.example.AppUtils.*;

public class PlayerDataUtils {
    public static JSONArray playerNameArray(){
        JSONArray playerArr = readFromJSON();
        String[] playerNameArr = new String[playerArr.size()];
        for (int i = 0; i < playerArr.size(); i++) {
            playerNameArr[i] = playerArr.get(i).toString().split("[,:]+")[3];
        }
        JSONArray userNameArr = new JSONArray();
        for (String s:playerNameArr) {
            userNameArr.add(s.replaceAll("\"",""));
        }
        return userNameArr;
    }
    public static JSONArray playerScoreArray(){
        JSONArray playerArr = readFromJSON();
        String[] playerScoreArr = new String[playerArr.size()];
        for (int i = 0; i < playerArr.size(); i++) {
            playerScoreArr[i] = playerArr.get(i).toString().split("[,:]+")[1];
        }
        JSONArray userScoreArr = new JSONArray();
        for (String s:playerScoreArr) {
            userScoreArr.add(s.replaceAll("\"",""));
        }
        return userScoreArr;
    }
    public static int getNumOfUsers(){
        JSONArray playerArr = readFromJSON();
        return playerArr.size();
    }
}
