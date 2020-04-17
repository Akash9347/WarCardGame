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
import java.util.ArrayList;

public class Card {
    private int value;
    private String name;
    private Player owner;

    public Card(String name, int value) {
        this.value = value;
        this.name = name;
    }


    //Getters and setters

    public Player getOwner(){
        return owner;
    }
    public void setOwner(Player owner){
        this.owner = owner;
    }
    public int getValue() {
        return value;
    }
    public String getName(){
        return name;
    }



}

