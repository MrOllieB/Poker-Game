package Poker_Project;


import java.util.ArrayList;
import java.util.Collections;


public class Deck
{
    private final ArrayList<Card> cards = new ArrayList<>();

    Deck()  // This is a constructor - you can tell because there is no return type, and it has the same name as the class itself
    {
            
        // Inside of here, add the nested loops to add 1 of each card to the deck.
        for (Suit s : Suit.values())    // For each suit we have
        {
            for (Rank r : Rank.values())    // Then for each rank inside of each suite
            {
                Card c = new Card(r, s);    // Make a Card object passing in Rank and Suit which adds it to itself.

                cards.add(c);               // And then add that new card to cards (ArrayList)
            }
        }

        //Shuffle the cards after adding them into the big deck
        Collections.shuffle(cards); // Using Collections class, shuffle makes them in random order

    }


    public int size()   // encapsulation - method to return size, instead of making size a public value. if it was public it could be changed in main and break the game
    {
        return cards.size();
    }

    public void cardsInDeck()
    {
        for (Card c : cards)    // I cant just println(c) due to encapsulation again. 
        {
            System.out.println(c.getDisplayName()); // made a new method to get display name, using suit and rank from inside of cards.
        }                                           // cant do suit.Name() or rank.Name() in here because its out of scope.
    }

    public Card dealCard()  // 'Card' because it needs to return that type, we will be adding it to our hand, so dealCard() needs to return one.
    {
        return cards.remove(0); // we can return the card we will be adding to our hand at the same time as removing it, as .remove on ArrayList also returns that element.
    }   // So intead of line 1 - remove it, line 2 - print / return its name value. They can both be done in 1 line. ^ Above explains how .remove on arrraylist removes it and returns its name value.
}   