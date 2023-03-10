package org.example;
import static org.example.AppUtils.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static org.example.GameUtils.*;
import static org.example.PlayerDataUtils.*;

public class PlayerUtils {
    public static JSONObject buildPlayerObj(String name, int score) {
        JSONObject playerObj = new JSONObject();
        playerObj.put("id", nextID());
        playerObj.put("name", name);
        playerObj.put("score", score);
        return playerObj;
    }
    public static JSONObject buildPlayerObj(String name, int score, int id) {
        JSONObject playerObj = new JSONObject();
        playerObj.put("id", id);
        playerObj.put("name", name);
        playerObj.put("score", score);
        return playerObj;
    }

    public static boolean checkPlayerName(String playerName) {
        boolean match = false;
        JSONArray userNameArr = playerNameArray();
        for (int i = 0; i < userNameArr.size(); i++) {
            if (userNameArr.get(i).toString().matches(playerName)) {
                match = true;
            }
        }
        return match;
    }
    public static int getPlayerId(String playerName) {
        int id=getNumOfUsers()+1;
        JSONArray userNameArr = playerNameArray();
        if (userNameArr.contains(playerName)) {
            id = userNameArr.indexOf(playerName);
        }
        return id;
    }
    public static int getPlayerScore(String playerName) {
        int id=getNumOfUsers()+1;
        JSONArray userNameArr = playerNameArray();
        if (userNameArr.contains(playerName)) {
            id = userNameArr.indexOf(playerName);
        }
        return id;
    }

}




