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
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class War {


    public static void main(String[] args) {
        ArrayList<Player> playerArrayList = new ArrayList<>();
        ArrayList<Card> deck = new ArrayList<>();
        Random rand = new Random();
        ArrayList<Card> placedCards = new ArrayList<>();
        Player winner = null;

        deck = populate();

        deck = shuffle(deck,rand);

        playerArrayList = addPlayers();

        deal(deck,playerArrayList);

        while(playerArrayList.get(0).getCards().size() > 0){

            placedCards = round(playerArrayList);
            getWinner(placedCards);
            placedCards.clear();
        }

        for(Player player : playerArrayList){
            System.out.println(player.getName() + " had " + player.getScore() + " points!");
        }


    }

    /*
    shuffle function takes the current deck of cards and shuffles it and returns the new deck
    it creates a second ArrayList and randomly picks a card from the main deck, using the current
    deck size as bounds then moves it into the newDeck. After it is in the newDeck it is removed
    from the main deck so it wont be picked again.
     */
    public static ArrayList<Card> shuffle(ArrayList<Card> deck, Random rnd){

        ArrayList<Card> newDeck = new ArrayList<>();
        int startSize = deck.size();
        int index;
        for(int i = 0; i<startSize;i++){

            index = rnd.nextInt(deck.size());
            newDeck.add(deck.get(index));
            deck.remove(index);
        }

        return newDeck;
    }

    /*
    populate is used to add 4 copies of every card the the deck.
    This is designed to be used at the very start, however it
    can be used to order the current deck but you must remember to
    first clear the deck as this wont do it for you.
     */
    public static ArrayList<Card> populate(){
        ArrayList<Card> deck = new ArrayList<>();
        for(CardTypes cardTypes : CardTypes.values()){
            deck.add(new Card(cardTypes.name,cardTypes.value));
            deck.add(new Card(cardTypes.name,cardTypes.value));
            deck.add(new Card(cardTypes.name,cardTypes.value));
            deck.add(new Card(cardTypes.name,cardTypes.value));
        }
        return deck;
    }

    /*
    deal will take the deck ArrayList and the player ArrayList
    It has a while loop to check if there are enough players to deal cards evenly
    In this while loop there is a foreach loop of the player array
    In this loop it will deal one card to each players hand and remove the card from the deck
    When there aren't enough players then it will stop running
     */
    public static void deal(ArrayList<Card> deck, ArrayList<Player> playerArrayList){
        while(deck.size()>= playerArrayList.size()){
            for (Player play : playerArrayList) {
                play.getCards().add(deck.get(deck.size() -1));
                play.getCards().get(play.getCards().size()-1).setOwner(play);
                deck.remove(deck.size()-1);
            }
        }
    }
    /*
    addPlayers
    This will ask the user how many players they want to add.
    For each player they must enter a name.
    Each player and their name is added to the playerList.
    Then the user is asked how many bots will be playing.
    For each bot playing a new Player is added to playerList.
    All bots have the isBot player variable as true.
    When done the function returns the playerList.
     */
    public static ArrayList<Player> addPlayers(){
        Scanner scanner = new Scanner(System.in);
        int playerCount = 0;
        int botCount = 0;
        ArrayList<Player> playerList = new ArrayList<>();

        //Adding players
        while(true) {
            System.out.println("How many players are there: ");
            try {
                playerCount = scanner.nextInt();
                break;
                //Catch if NaN
            } catch (InputMismatchException e) {
                System.out.println("Must be a number.");
            }
        }
        for(int i = 0; i<playerCount;i++){
            System.out.println("Please enter player name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            playerList.add(new Player(name,false));
        }
        while(true){
            try {
                System.out.println("Please enter amount of bots: ");
                botCount = scanner.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("Must be a number.");
            }
        }
        for(int i = 0; i <botCount;i++){
            playerList.add(new Player("Computer: " + i,true));
        }
        return playerList;
    }
    /*
    round
    This function loops through the player array and runs pickCard()
    for each player and adds the card to the ArrayList of cards currently
    being "on the table"
    When all players have placed a card the ArrayList is returned.
     */
    public static ArrayList<Card> round(ArrayList<Player> playerArrayList){
        ArrayList<Card> playedCards = new ArrayList<>();

        for(Player player : playerArrayList){
            playedCards.add(pickCard(player));
        }
        return playedCards;
    }

    public static void getWinner(ArrayList<Card> placedCards){
        Card winningCard;
        Boolean isTie = false;
        winningCard = null;
        for(Card card : placedCards){
            if(winningCard == null){
                winningCard = card;
            } else if(winningCard.getValue() < card.getValue()){
                winningCard = card;
            } else if(winningCard.getValue() == card.getValue()){
                isTie = true;
            }
        }
        if(isTie){
            System.out.println("Round was a tie.");

        }else{
            System.out.println("Winner is: " + winningCard.getOwner().getName());
            winningCard.getOwner().wonRound();

        }
    }


    /*
    pickCard
    This handles user input for the given player.
    Shows players name and asks for input, if the
    player asks for options then all the players
    cards are shown.
    If the player enters something that isn't in
    their hand then they are prompted to re enter
    the card they want.

    When a card has been selected it is put in the return statement
     */
    public static Card pickCard(Player player){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String selection;
        Boolean hasCard = true;
        Card pickedCard = null;
        while(hasCard) {
            if(player.getIsBot()){
                int index = random.nextInt(player.getCards().size());
                pickedCard = player.getCards().get(index);
                player.getCards().remove(index);
                hasCard = false;
            }else {
                System.out.println(player.getName());
                System.out.println("Please play a card. To see options type 'options'");
                selection = scanner.nextLine();
                if (selection.equalsIgnoreCase("options")) {
                    player.printCards();
                } else if (!selection.equalsIgnoreCase("options")) {
                    for (Card card : player.getCards()) {
                        if (card.getName().equalsIgnoreCase(selection)) {
                            hasCard = false;
                            pickedCard = card;
                            player.getCards().remove(card);
                            break;
                        }
                    }
                    if (hasCard) {
                        System.out.println("No such card please try again!");
                    }
                }
            }
        }
        return pickedCard;
    }
}
