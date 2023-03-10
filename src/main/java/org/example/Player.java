package org.example;
public class Player {
    private String name;

    public void setLives() {
        this.lives = 8;
    }
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
    public void setScore(int score){
        this.score += score;
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
