package org.example;
import static org.example.GameUtils.*;
public class PictureArr {

    private String[] hangMan = new String[8];

    public String getHangMan(int index) {
        return hangMan[index];
    }

    public PictureArr() {
        this.hangMan[7] = String.join(newLine,
                "AFTER 1 INCORRECT GUESSES",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "_______");
        this.hangMan[6] = String.join(newLine,
                "AFTER 2 INCORRECT GUESSES",
                "       ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "___|___");
        this.hangMan[5] = String.join(newLine,
                "AFTER 3 INCORRECT GUESSES",
                "   _______",
                "   |/  ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "___|___");
        this.hangMan[4] = String.join(newLine,
                "AFTER 4 INCORRECT GUESSES",
                "   _______",
                "   |/    |",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "   |   ",
                "___|___");
        this.hangMan[3] = String.join(newLine,
                "AFTER 5 INCORRECT GUESSES",
                "   _______",
                "   |/    |",
                "   |    (_)",
                "   |",
                "   |",
                "   |",
                "   |",
                "   |",
                "___|___");
        this.hangMan[2] = String.join(newLine,
                "AFTER 6 INCORRECT GUESSES",
                "   _______",
                "   |/    |",
                "   |    (_)",
                "   |    /|/",
                "   |     |",
                "   |",
                "   |",
                "   |",
                "___|___");
        this.hangMan[1] = String.join(newLine,
                "AFTER 7 INCORRECT GUESSES",
                "   _______",
                "   |/    |",
                "   |    (_)",
                "   |    /|/",
                "   |     | ",
                "   |    /",
                "   |   /",
                "   |   ",
                "___|___");
        this.hangMan[0] = String.join(newLine,
                "End of Game No Guess's Left",
                "   _______",
                "   |/    |",
                "   |    (_)",
                "   |    /|\\",
                "   |     | ",
                "   |    / \\",
                "   |   /   \\ ",
                "   |   ",
                "___|___");

    }
}
