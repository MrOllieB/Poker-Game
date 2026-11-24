package Poker_Project;

import java.util.ArrayList;
import java.util.HashMap;

public class HandDetection
{

    public void evaluateHands(Hands playerHand, Hands tableHand)
    {

        ArrayList<Card> combinedCards = new ArrayList<>();

        ArrayList<Card> playerCards = playerHand.getHand();
        ArrayList<Card> tableCards = tableHand.getHand();

        // Then combine them together


        for (Card c : playerCards)
        {
            combinedCards.add(c);    
        }


        for (Card c : tableCards)
        {
            combinedCards.add(c);
        }

        // Then count ranks


        // Will use a hashmap for key : value pairs. Rank will be they key, value will be the count
        // Easiest way to count ranks

        HashMap<Rank, Integer> rankCount = new HashMap<>();

        for (Card c : combinedCards)
        {

            Rank r = c.getRank();   // insteaed of doing c.getrank each time, and looks better.

            if (rankCount.containsKey(r))   // Is this rank already counted?
            {
                rankCount.put(r, rankCount.get(r) + 1); // .get(r) gets the value assigned to key (r) , then adds 1 to it as its been counted again
            }    
            else        // This rank is not yet counted.
            {
                rankCount.put(r, 1);    // adds the rank to the count, and counts it to 1
            }
        }

        System.out.println(rankCount);

    }


}
