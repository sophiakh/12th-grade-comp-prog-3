package solitaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import solitaire.Card.Suit;

public class Solitaire {
	public ArrayList<Stack <Card>> columns;
	public Queue<Card> deck;
	public ArrayList<Stack <Card>> found;
	public ArrayList<Card> tal;
	public ArrayList<Card> hid;
	
	//the part of your program that's in charge of game rules goes here.
	public Solitaire()
	{
		columns = new ArrayList<Stack <Card>>();
		deck = new LinkedList<>(); //Queue is an interface!
		initiate();
		found = new ArrayList<Stack <Card>>();
		for(int i=1; i<=4; i++)
			found.add(new Stack<Card>());
		
		tal = new ArrayList<Card>();//talon
		hid = new ArrayList<Card>();//hidden cards that can return 
		//after card is moved successfully from talon
	}
	
	//precondition: all instance variables have been initialized
	//postcondition: deck contains a fully shuffled deck of cards and the column piles are properly populated.
	private void initiate()
	{
		ArrayList<Card> temp = new ArrayList<Card>();
		for(Suit suit : Suit.values())
		{
			for(int value = 1; value <= 14; ++value) 
			{
				if(value != 11)
					temp.add(new Card(value, suit));	
			}
		}
		Collections.shuffle(temp);
		deck.addAll(temp);
		
		for(int i=1; i<=7; i++) {
			columns.add(new Stack<Card>());
			for(int j=0; j<i; j++) 
			{
				columns.get(columns.size()-1).add(deck.remove());
			}
		}
		System.out.println(columns);
	}	
	
	//pre-condition: both cards being sent in exist. We are not sending the card to an empty slot
	//post-condition: returns “true” if the proposed move is a legal one, taking into account the different ways cards are moved in Solitaire (middle piles vs final piles)
	//note* this method shouldn’t move anything, just let us know if this is a legal move or not
	
	public boolean legalMove(Card toMove, Card location)
	{
		//PLANNING START
		//////////////////////////////////////////////////
		//1: Card in talon wants to move. 
		//Must be top card, therefore visible and first in list
		
		//If it is top card, it CAN move to:
		//foundation if its ace and correct suit
		//tableau if follows color + num pattern
		//hidden if another card from deck is called, separate operation irrelevant to this function
		
		//CAN'T move to:
		//deck
		//talon itself
		
		//2: Card in deck wants to move.
		//Must be top card in queue, but invisible to viewer
		
		//Can move to talon
		
		//Can't move anywhere else(foundation, tab, hidden, deck)
		
		//3: Card in tableau wants to move.
		//Must be top card, therefore visible
		//Can move to: 
		//Other tab pile, if follows color +  num pattern
		//Foundation if its ace and correct suit
		
		//Can't move anywhere else (talon, hidden, deck)
		
		//4: Card in hidden wants to move.
		//Must be top card, but invisible to viewer
		//Can move to talon
		
		//Can't move anywhere else (hidden, deck, found, tab)
		
		//5: Card in foundation wants to move.
		//Must be top card, therefore visible
		//Can move to tab if follows color + num pattern
		
		//Can't move anywhere else (talon, hidden, deck, found)
		
		//////////////////////////////////////////////////
		//PLANNING END
		
		//METHOD START
		boolean legal = false;
		
		//////////////////////////////////////////////////////////
		//if talon contains card that is to be moved...
		if(tal.contains(toMove))
		{
			if (tal.get(tal.size()-1).equals(toMove))
			{
				//Now, knowing that the toMove card (on its own) is legal, let's find where the location card is!
				
				//is location card in one of the tableau columns?
				if (columns.get(0).contains(location) || columns.get(1).contains(location) || columns.get(2).contains(location) || columns.get(3).contains(location) || columns.get(4).contains(location) || columns.get(5).contains(location) || columns.get(6).contains(location))
				{
					for(Stack<Card> i : columns)
					{
						if(i.contains(location))
						{
							Object cards[];
							cards = i.toArray();
							Card top = (Card)cards[cards.length-1];
							
							//does it follow Solitaire rules??
							if (top.equals(location) && top.suit.isRed != toMove.suit.isRed && top.value == toMove.value+1)
							{
								System.out.println("Passes talon to tableau check!");
								legal = true;
							}
						}
					}
				}
				
				//is location card in one of the foundation slots?
				//DOESN'T account for when foundation slot is empty, should be done in separate function lol
				else if(found.get(0).contains(location) || found.get(1).contains(location) || found.get(2).contains(location) || found.get(3).contains(location))
				{
					Object cards[];
					Card top;
					//turn appropriate foundation stack into array and initialize top
					if (found.get(0).contains(location))
					{
						cards = found.get(0).toArray();
						top = (Card)cards[cards.length-1];
					}
						
					else if (found.get(1).contains(location))
					{
						cards = found.get(1).toArray();
						top = (Card)cards[cards.length-1];
					}
						
					else if (found.get(2).contains(location))
					{
						cards = found.get(2).toArray();
						top = (Card)cards[cards.length-1];
					}
						
					else
					{
						cards = found.get(3).toArray();
						top = (Card)cards[cards.length-1];
					}
					
					
					//does it follow Solitaire rules??
					if (top.equals(location))
					{
						if (toMove.suit.isRed == location.suit.isRed)
						{
							if (location.value == toMove.value-1)
							{
								System.out.println("Passes talon to foundation check!");
								legal = true;
							}
						}
					}
				}
			}
		}
		//////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////
		//if tableau contains card that is to be moved...
		//this is EXCELLENT code
		else if(columns.get(0).contains(toMove) || columns.get(1).contains(toMove) || columns.get(2).contains(toMove) || columns.get(3).contains(toMove) || columns.get(4).contains(toMove) || columns.get(5).contains(toMove) || columns.get(6).contains(toMove))
		{
			for(Stack<Card> i : columns)
			{
				if(i.contains(toMove))
				{
					Object cards[];
					cards = i.toArray();
					Card top = (Card)cards[cards.length-1];
					
					if (top.equals(toMove))
					{
						//could put location search in here, but should I?? Yes
						//Is location card in a column that ISN'T the the same as the one toMove is in?
						for(Stack<Card> i2 : columns)
						{
							if(i2.contains(location) && !i2.equals(i))
							{
								cards = i2.toArray();
								top = (Card)cards[cards.length-1];
								
								//does it follow Solitaire rules??
								if (top.equals(location) && top.suit.isRed != toMove.suit.isRed && top.value == toMove.value+1)
								{
									System.out.println("Passes tableau to tableau check!");
									legal = true;
								}
							}
						}
						//is location card in the foundation?
						if(found.get(0).contains(location) || found.get(1).contains(location) || found.get(2).contains(location) || found.get(3).contains(location))
						{
							//turn appropriate foundation stack into array
							if (found.get(0).contains(location))
								cards = found.get(0).toArray();
							else if (found.get(1).contains(location))
								cards = found.get(1).toArray();
							else if (found.get(2).contains(location))
								cards = found.get(2).toArray();
							else
								cards = found.get(3).toArray();
							
							top = (Card)cards[cards.length-1];
							
							//does it follow Solitaire rules??
							if (toMove.suit.isRed == location.suit.isRed)
							{
								if(top.equals(location))
								{;
									if(top.value == toMove.value-1)
									{
										legal = true;
									}
								}
							}
						}
					}
				}
			}
		}
		//////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////
		//if foundation contains card that is to be moved...
		else if(found.get(0).contains(toMove) || found.get(1).contains(toMove) || found.get(2).contains(toMove) || found.get(3).contains(toMove))
		{
			for(Stack<Card> i : found)
			{
				if(i.contains(toMove))
				{
					Object cards[];
					cards = i.toArray();
					Card top = (Card)cards[cards.length-1];
					
					if (top.equals(toMove))
					{
						//is location card in tableau?
						if (columns.get(0).contains(location) || columns.get(1).contains(location) || columns.get(2).contains(location) || columns.get(3).contains(location) || columns.get(4).contains(location) || columns.get(5).contains(location) || columns.get(6).contains(location))
						{
							for(Stack<Card> i2 : columns)
							{
								if(i2.contains(location))
								{
									cards = i2.toArray();
									top = (Card)cards[cards.length-1];
									
									//does it follow Solitaire rules??
									if (top.equals(location) && top.suit.isRed != toMove.suit.isRed && top.value == toMove.value+1)
									{
										System.out.println("Passes foundation to tableau check!");
										legal = true;
									}
								}
							}
						}
						
					}
				}
			}
		}
		//////////////////////////////////////////////////////////
		
		return legal;
	} 
}