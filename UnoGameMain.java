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
    Computer computer = new Computer(); // Create new computer player for first game type
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
        String wildInput = "";
        System.out.println("The letter represents the color of the card, and the number represents the number.");
        System.out.println("A wild allows the player to change the color the next player must play. The number after WD means the opposite player must draw that amount of cards before their turn.");
        System.out.println("The player must play a card that is either the same color or number as the last played card. First to 0 cards wins!");
        while(playerMove == 1)
        {
          System.out.println("Player 1, please play a card or [Draw]");
          player1.printHand();
          String inputStatement = "";
          int playerStep = 1;
          if(playerGame.equals("1"))
          {
            inputStatement = player1.returnCard();
          }
          else
          {
            inputStatement = in.next();
          }
          if(inputStatement.equals("Draw"))
          {
            player1.drawCard();
            playerStep = 2;
            while(playerStep == 2)
            {
              System.out.println("Player 1, please play a card or [Pass]");
              if(playerGame.equals("1"))
              {
                inputStatement = player1.returnCard();
              }
              else
              {
                inputStatement = in.next();
              }
              if(inputStatement.equals("Pass"))
              {
                playerMove = 2;
              }
              else
              {
                if(gamePile.pileCheck(inputStatement) && player1.checkCard(inputStatement))
                {
                  player1.playCard(inputStatement);
                  if(inputStatement.substring(0,1).equals("W"))
                  {
                    System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                    if(playerGame.equals("1"))
                    {
                      wildInput = player1.returnWildColor();
                    }
                    else
                    {
                      wildInput = in.next();
                    }
                    if(gamePile.wildColor(wildInput))
                    {
                      gamePile.setPileValues(wildInput+"0");
                    }
                    if(inputStatement.length() > 2)
                    {
                      player2.drawForWild(inputStatement.substring(2));
                      player2.printHand();
                    }
                  }
                  playerMove = 2;
                }
                else
                {
                  System.out.println("Invalid Entry");
                  playerStep = 2;
                }
              }
            }
          }
          else
          {
            if(gamePile.pileCheck(inputStatement) && player1.checkCard(inputStatement))
            {
              player1.playCard(inputStatement);
              if(inputStatement.substring(0,1).equals("W"))
              {
                System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                if(playerGame.equals("1"))
                {
                  wildInput = player1.returnWildColor();
                }
                else
                {
                  wildInput = in.next();
                }
                if(gamePile.wildColor(wildInput))
                {
                  gamePile.setPileValues(wildInput+"0");
                }
                if(inputStatement.length() > 2)
                {
                  player2.drawForWild(inputStatement.substring(2));
                  player2.printHand();
                }
              }
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
            System.out.println("Player 2, please play a card or [Draw]");
            player2.printHand();
            inputStatement = in.next();
            int playerTwoStep = 1;
            if(inputStatement.equals("Draw"))
            {
              player2.drawCard();
              playerTwoStep = 2;
              while(playerTwoStep == 2)
              {
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
                    if(inputStatement.substring(0,1).equals("W"))
                    {
                      System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                      wildInput = in.next();
                      if(gamePile.wildColor(wildInput))
                      {
                        gamePile.setPileValues(wildInput+"0");
                      }
                      if(inputStatement.length() > 2)
                      {
                        player1.drawForWild(inputStatement.substring(2));
                        player1.printHand();
                      }
                    }
                    playerMove = 1;
                  }
                  else
                  {
                    System.out.println("Invalid Entry");
                    playerTwoStep = 2;
                  }
                }
              }
            }
            else
            {
              if(gamePile.pileCheck(inputStatement) && player2.checkCard(inputStatement))
              {
                player2.playCard(inputStatement);
                if(inputStatement.substring(0,1).equals("W"))
                {
                  System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                  wildInput = in.next();
                  if(gamePile.wildColor(wildInput))
                  {
                    gamePile.setPileValues(wildInput+"0");
                  }
                  if(inputStatement.length() > 2)
                  {
                    player1.drawForWild(inputStatement.substring(2));
                    player1.printHand();
                  }
                }
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