//Uno Game
//William Kwok
//Langraf

import java.util.Scanner;
public class UnoGameMain
{
  public static void main(String[] args)
  {
    int programStep = 0; // Step for simple turn executions for program
    Pile gamePile = new Pile(); // Create new game pile
    Player computer = new Computer(); // Create new computer player for first game type
    Player startPlayer1 = new Player(); // Create new player for first and second game type
    Player startPlayer2 = new Player(); // Create new player for second game type
    Player player1 = new Player(); // Creates new players to be set to player 1 and 2 after program starts 
    Player player2 = new Player();
    int playerMove = 1; // Creates starting player turn
    while(programStep == 0)
    {
      Scanner in = new Scanner(System.in); // Creates new scanner
      System.out.println("Do you want to play with a friend or a computer player? Type 1 for computer and 2 for friend");
      String playerGame = in.next();
      if(playerGame.equals("1")) // If single player, set player1 and player2 to computer and a player
      { 
        player1 = computer;
        player2 = startPlayer1;
        programStep = 1;
      }
      else if(playerGame.equals("2")) // If double player, set player1 and player2 to player and player
      {
        player1 = startPlayer1;
        player2 = startPlayer2;
        programStep = 1;
      }
      else // Detects if person input a different integer value
      {
        System.out.println("Invalid entry");
        programStep = 0;
      }
      
      if(programStep == 1)
      {
        String playerReturnStatement = "";
        while(playerMove == 1)
        {
          player1.printHand();
          System.out.println("Player 1, please play a card or [Draw]");
          String inputStatement = in.next();
          if(inputStatement.equals("Draw"))
          {
            player1.drawCard();
            System.out.println("Player 1, please play a card or [Pass]");
            inputStatement = in.next();
            if(inputStatement.equals("Pass"))
            {
              playerMove = 2;
            }
            else
            {
              if(gamePile.pileCheck(inputStatement) && player1.checkCard(inputStatement))
              {
                player1.playCard(inputStatement);
                playerMove = 2;
              }
              else
              {
                System.out.println("Invalid Entry");
                playerMove = 1;
              }
            }
          }
          else
          {
            if(gamePile.pileCheck(inputStatement) && player1.checkCard(inputStatement))
            {
              player1.playCard(inputStatement);
              playerMove = 2;
            }
            else
            {
              System.out.println("Invalid Entry");
              playerMove = 1;
            }
          }
          
          while(playerMove == 2)
          {
            player2.printHand();
            System.out.println("Player 2, please play a card or [Draw]");
            inputStatement = in.next();
            if(inputStatement.equals("Draw"))
            {
              player2.drawCard();
              System.out.println("Player 2, please play a card or [Pass]");
              inputStatement = in.next();
              if(inputStatement.equals("Pass"))
              {
                playerMove = 1;
              }
              else
              {
                if(gamePile.pileCheck(inputStatement) && player2.checkCard(inputStatement))
                {
                  player2.playCard(inputStatement);
                  playerMove = 1;
                }
                else
                {
                  System.out.println("Invalid Entry");
                  playerMove = 2;
                }
              }
            }
            else
            {
              if(gamePile.pileCheck(inputStatement) && player2.checkCard(inputStatement))
              {
                player2.playCard(inputStatement);
                playerMove = 1;
              }
              else
              {
                System.out.println("Invalid Entry");
                playerMove = 2;
              }
            }
          }
        }
      }
    }
  }
}