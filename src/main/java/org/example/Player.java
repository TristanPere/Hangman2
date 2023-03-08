package org.example;
public class Player {
    private String name;
    private int lives;

    public Player(String name) {
        this.name = name;
        this.lives = 8;
    }

    public void looseLife() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }
    public void looseEverything() {this.lives=0;}
}
