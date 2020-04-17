/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oxford
 */
public class WarTest {
    
    public WarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class War.
     */
  /**  @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        War.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
**/
    
 
 

    /**
     * Test of populate method, of class War.
     */
    @Test
    public void testPopulate() {
        System.out.println("populate");
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = War.populate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deal method, of class War.
     */
    @Test
    public void testDeal() {
        System.out.println("deal");
        ArrayList<Card> deck = null;
        ArrayList<Player> playerArrayList = null;
        War.deal(deck, playerArrayList);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayers method, of class War.
     */
    @Test
    public void testAddPlayers() {
        System.out.println("addPlayers");
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = War.addPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of round method, of class War.
     */
    @Test
    public void testRound() {
        System.out.println("round");
        ArrayList<Player> playerArrayList = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = War.round(playerArrayList);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getWinner method, of class War.
     */
    @Test
    public void testGetWinner() {
        System.out.println("getWinner");
        ArrayList<Card> placedCards = null;
        War.getWinner(placedCards);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of pickCard method, of class War.
     */
    @Test
    public void testPickCard() {
        System.out.println("pickCard");
        Player player = null;
        Card expResult = null;
        Card result = War.pickCard(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     public void DealTesterTwoPlayer(){
        ArrayList<Player> playerlist = new ArrayList<>();
        ArrayList<Card> deck = new ArrayList<>();
        deck = War.populate();
        boolean expResult = true;
        playerlist.add(new Player("Test1", true));
        playerlist.add(new Player("Test2", true));
        War.deal(deck,playerlist);
        assertEquals(playerlist,expResult);
    }
    
    public void DealTesterThreePlayer(){
        ArrayList<Player> playerlist = new ArrayList<>();
        ArrayList<Card> deck = new ArrayList<>();
        deck = War.populate();
        playerlist.add(new Player("Test1", true));
        playerlist.add(new Player("Test2", true));
        playerlist.add(new Player("Test3", true));
        War.deal(deck,playerlist);
        assertEquals(deck,playerlist);
    }
    
}
