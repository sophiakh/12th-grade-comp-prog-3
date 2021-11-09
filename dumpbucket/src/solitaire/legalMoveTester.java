package solitaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Stack;
import solitaire.Card.Suit;

public class legalMoveTester {
    Solitaire toTest;
    Card heartsTwo = new Card(2, Suit.Hearts);
    Card spadesFive = new Card(5, Suit.Spades);
    Card heartsSix = new Card(6, Suit.Hearts);
    Card clubsFive = new Card(5, Suit.Clubs);
    Card diamondsFour= new Card(4, Suit.Diamonds);
    Card diamondsThree= new Card(3, Suit.Diamonds);
    Card spadesThree= new Card(3, Suit.Spades);
    Card diamondsFive = new Card(5, Suit.Diamonds);
    Card heartsAce = new Card(1, Suit.Hearts);
    Card spadesFour = new Card(4, Suit.Spades);
    Card spadesSeven = new Card(7, Suit.Spades);
    Card heartsFive = new Card(5, Suit.Hearts);
    Card heartsFour = new Card(4, Suit.Hearts);
    Card clubsThree= new Card(3, Suit.Clubs);
    Card clubsFour= new Card(4, Suit.Clubs);
    
    @BeforeEach
    void setUp() {
        toTest = new Solitaire();
        
        toTest.columns.get(0).push(heartsTwo);
        toTest.columns.get(1).push(diamondsFive);
        toTest.columns.get(2).push(clubsFour);
        toTest.columns.get(2).push(heartsSix);
        toTest.columns.get(2).push(clubsFive);
        toTest.columns.get(2).push(diamondsFour);
        toTest.columns.get(2).push(diamondsThree);
        toTest.columns.get(3).push(spadesThree);
        toTest.columns.get(4).push(spadesSeven);
        toTest.columns.get(5).push(heartsFive);
        toTest.columns.get(6).push(heartsFour);
        
        toTest.tal.add(spadesFive);

        toTest.found.get(0).add(heartsAce);
        toTest.found.get(2).add(clubsThree);
        toTest.found.get(3).add(spadesFour);
    }
    
    //true cases
    @Test
    void fromCenterToFinal(){
        assertTrue(toTest.legalMove(heartsTwo, heartsAce));
    }
    
    @Test
    void fromPileToFinal(){
        assertTrue(toTest.legalMove(spadesFive, spadesFour));
    }
    
    @Test
    void fromCenterToCenter(){
        assertTrue(toTest.legalMove(heartsTwo, spadesThree));
    }
    
    @Test
    void fromCenterToCenterStacked() {
        assertTrue(toTest.legalMove(heartsSix, spadesSeven));
    }
    
    @Test
    void fromFinalToCenter() {
        assertTrue(toTest.legalMove(spadesFour, heartsFive));
    }
    
    //false cases
    @Test
    void fromCenterToPile() {
        assertFalse(toTest.legalMove(heartsFour, spadesFive));
    }
    @Test
    void fromCenterToPile2() {
        assertFalse(toTest.legalMove(spadesThree, spadesFive));
    }
    @Test
    void fromCenterToMiddleCenter() {
        assertFalse(toTest.legalMove(heartsFour, clubsFive));
    }
    @Test
    void fromPileToMiddleCenter() {
        assertFalse(toTest.legalMove(spadesFive, heartsSix));
    }
    @Test
    void fromFinaltoMiddleCenter() {
        assertFalse(toTest.legalMove(clubsThree, diamondsFour));
    }
    @Test
    void fromCenterToFinalWrong() {
        assertFalse(toTest.legalMove(clubsFour, clubsThree));
    }
    @Test
    void fromCenterToFinalWrong2() {
        assertFalse(toTest.legalMove(heartsFour, clubsThree));
    }
    @Test
    void fromFinaltoPile() {
        assertFalse(toTest.legalMove(heartsFour, clubsThree));
    }
    
    
}