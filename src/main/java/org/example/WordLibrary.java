package org.example;
public class WordLibrary {
    private String[] words;

    public WordLibrary(String[] words) {
        this.words = words;
    }
    public WordLibrary(){ this.words = new String[] {"Octopus", "Brown", "Apple", "Pencil", "Case", "Super", "Robin", "Orange", "Rabbit", "Tower", "Eiffel", "Falafel"};}

    public String randomWord() {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }

}
