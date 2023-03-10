package org.example;


import static org.example.AppUtils.*;
import static org.example.PlayerUtils.*;

public class GameUtils {
    private static String userName;
    private static boolean isNewUser;

    public static boolean isNewUser() {
        return isNewUser;
    }

    public static String getUserName() {
        return userName;
    }
    public static void loginCheck(int loginType) {
        if (loginType == 1) {
            System.out.println("Please enter your unique username");
            String userNameInput = Scanner().nextLine();
            if (checkPlayerName(userNameInput)) {
                System.out.println("Welcome Back:" + userNameInput);
                userName=userNameInput;
                isNewUser=false;
            } else {
                System.out.println("This username does not match any we have on file.");
                System.out.println("Please try again(1) or Login as a NewUser(2)");
                String login = Scanner().nextLine();
                if (isAnInteger(login)) {
                    loginCheck(Integer.parseInt(login));
                } else {
                    loginCheck(3);
                }
            }
        } else if (loginType == 2) {
            System.out.println("Please enter your new unique username");
            String userNameInput = Scanner().nextLine();
            userName=userNameInput;
            isNewUser=true;
        } else {
            System.out.println("Please enter a valid number. Login(1) | NewUser(2)");
            String login = Scanner().nextLine();
            if (isAnInteger(login)) {
                loginCheck(Integer.parseInt(login));
            } else {
                loginCheck(3);
            }
        }
    }
}
