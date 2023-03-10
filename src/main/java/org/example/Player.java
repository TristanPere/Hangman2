package org.example;

public class Player {
    private String name;
    private int lives;
    private int score;
    public Player(String name) {
        this.name = name;
        this.lives = 8;
    }

    public int getScore() {
        return score;
    }

    public void setScore(){
        this.score +=100;
    }
    public String getName() {
        return name;
    }

    public void looseLife() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }
    public void looseEverything() {this.lives=0;}

}
