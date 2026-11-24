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
        // Table has been set up - table reveals 3 cards after players choose what they want to do
        System.out.println("Table: ");
        table.showHand();

        if (!user_folded)
        {
            EvaluateDecision(DecisionTime());
        }



        DealToTable(1);     // Give table 1 more card, now 4
        table.showHand();
        if (!user_folded)
        {
            EvaluateDecision(DecisionTime());  
        }



        DealToTable(1);     // Give table 1 more card, now 5
        table.showHand();
        if (!user_folded)
        {
            EvaluateDecision(DecisionTime());  // Final time to either go all in or stick, before revealing cards to 
        }



        System.out.println("Tables final hand: ");
        table.showHand();  

        System.out.println();
        System.out.println("Player 1 hand: ");
        player1.showHand();

        System.out.println();
        System.out.println("Player 2 hand: ");
        player2.showHand();


        // This is the table with 5 cards on it

        // Next players will reveal their hands and decide who wins.



        HandDetection detector = new HandDetection();

        System.out.println("player 1: ");
        detector.evaluateHands(player1, table);
        System.out.println();

        System.out.println("Player 2: ");
        detector.evaluateHands(player2, table);
        System.out.println();

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
