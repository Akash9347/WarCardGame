/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Oxford
 */
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();
    private int score;
    private Boolean isBot;


    public Player(String name,Boolean isBot){
        setName(name);
        setIsBot(isBot);
    }


    public void printCards(){
        for(Card card : cards){
            System.out.println(card.getName());
        }
    }
    //Getters and setters
    //Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //isBot
    public Boolean getIsBot(){
        return isBot;
    }
    public void setIsBot(Boolean isBot){
        this.isBot = isBot;
    }
    //Score
    public int getScore(){
        return score;
    }
    public void setScore(int newScore){
        this.score = newScore;
    }
    public void wonRound(){
        this.score++;
    }
    //cards
    public ArrayList<Card> getCards(){
        return cards;
    }
}
