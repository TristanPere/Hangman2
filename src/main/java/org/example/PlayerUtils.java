package org.example;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static org.example.GameUtils.*;

public class PlayerUtils {
    public static JSONObject buildPlayerObj(String name, int score){
        JSONObject playerObj = new JSONObject();
        playerObj.put("id",nextID());
        playerObj.put("name", name);
        playerObj.put("score", score );
        return playerObj;
    }
//    public static boolean checkPlayerName(String playerName){
//       JSONArray playerArr = readFromJSON();
//       JSONArray playerObjArr = new JSONArray();
//        for (int i=0;i<playerArr.size();i++) {
//            playerObjArr.add(i,playerArr.get(i));
//        }
//
//        for (int i = 0; i < playerArr.size(); i++) {
//            playerObjArr.get(i).toString();
//        }
//    };

}
