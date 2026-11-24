package Poker_Project;

import java.util.ArrayList;

public class Hands
{
    private final ArrayList<Card> handCreated = new ArrayList<>();  // 1 hand created for the object instance made. E.g Hands table = new.... table now gets a 'handCreated' assigned to it.
    private final Deck deck;


    Hands(Deck deck)
    {
        this.deck = deck;
    }

    public void DealCard(int num_cards)        // deals 1 card at a time to whichever type called it.
    { // deal card is found inside of deck class

        for (int index = 0; index < num_cards; index++)
        {
            handCreated.add(deck.dealCard());
        }
    } 


    // remove type
    public void showHand()      // as a param, we dont need to specify which hand we are trying to show, (E.g player1.deckCreated), as just by calling it on table.showHand(), were calling it on table, which knows it has a handCreated value.
    {
        for (Card c : handCreated)
        {
            System.out.println(c.getDisplayName());
        }
    }


    public ArrayList<Card> getHand()    // Getter for hand detection, as handCreated is private (good as cant be changed / cheated)
    {                                   // as its private it needs a getter.
        return this.handCreated;
    }

}
