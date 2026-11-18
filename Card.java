package Poker_Project;

public class Card
{
    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public String getDisplayName()      // get display name method for encapsulation, can be used anywhere, but suit and rank cannot as they are private and final
    {
        return rank.name() + " of " + suit.name();
    }
}