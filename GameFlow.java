package Poker_Project;

import java.util.Scanner;

public class GameFlow
{

    Scanner scanner = new Scanner(System.in);

    Deck deck = new Deck();

    Hands player1 = new Hands(deck);
    Hands player2 = new Hands(deck);
    Hands table = new Hands(deck);

    boolean user_folded = false;

    public void Game()
    {
        System.out.println("Hello World");
        // setting up the game
        DealToPlayer(player1, 2);   // deal 2 cards to each player
        DealToPlayer(player2, 2);   // 2 to player 2
        System.out.println("Player 1's hand");
        player1.showHand();
        System.out.println("Player 2's hand:");
        player2.showHand();

        System.out.println("--------------------");

        System.out.println("Table: ");  // show the tables cards
        table.showHand();

        EvaluateDecision(DecisionTime());   // player decision beforte seeing table's hand

        DealToTable(3);
        // Table has been set up
        System.out.println("Table: ");
        table.showHand();

        if (!user_folded)
        {
            EvaluateDecision(DecisionTime());
        }



        DealToTable(1);
        table.showHand();
        if (!user_folded)
        {
            EvaluateDecision(DecisionTime());  
        }

        DealToTable(1);

        if (!user_folded)
        {
            EvaluateDecision(DecisionTime());
        }

        System.out.println("Tables hand is: ");
        table.showHand();

    }

    public void DealToPlayer(Hands player, int num_cards)
    {
        player.DealCard(num_cards);
    }


    public void DealToTable(int num_cards)
    {
        table.DealCard(num_cards);
    }





    public void EvaluateDecision(String user_decision)
    {
        switch (user_decision) {
            case "1":
                System.out.println("Check");
                break;
            case "2":
                System.out.println("Bet");
                System.out.println("User increasing their bet");
                break;
            case "3":
                System.out.println("Fold");
                user_folded = true;
                break;



            default:
                System.out.println("Invalid choice");
                break;
        }
    }




    public String DecisionTime()
    {
        System.out.println("Decision: ");

        System.out.println("1. Check");
        System.out.println("2. Bet");
        System.out.println("3. Fold");

        System.out.print("Choose 1-3: ");
        String user_decision = scanner.nextLine();

        return user_decision;
    }


}
