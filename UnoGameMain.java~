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
    Player player1 = new Player(); // Creates new players to be set to player 1 and 2 after program starts 
    Player player2 = new Player();
    int playerMove = 1; // Creates starting player turn
    while(programStep == 0)
    {
      Scanner in = new Scanner(System.in); // Creates new scanner
      System.out.println("Do you want to play with a friend or a computer player? Type 1 for computer and 2 for friend");
      String playerGame = in.next();
      if(playerGame.equals("1") || playerGame.equals("2")) // Moves onto next step of program
      { 
        programStep = 1;
      }
      else // Detects if person input a different integer value
      {
        System.out.println("Invalid entry");
        programStep = 0;
      }
      
      if(programStep == 1) // Program step 1, main game
      {
        String inputStatement = ""; // Creates input String so player can input after
        String wildInput = ""; // Wild input so player can set wild color when playing a wild card
        System.out.println("Instructions:"); // Intro lines
        System.out.println("The letter represents the color of the card, and the number represents the number.");
        System.out.println("A wild allows the player to change the color the next player must play. The number after WD means the opposite player must draw that amount of cards before their turn.");
        System.out.println("The player must play a card that is either the same color or number as the last played card. First to 0 cards wins!");
        System.out.println("");
        while(playerMove == 1)
        {
          if(playerGame.equals("1"))
          {
            if(computer.handSizeZero() == 0 || player2.handSizeZero() == 0) // If any player's handsize is detected to be zero, immediately go to next step of program
            {
              programStep = 2;
            }
            gamePile.pileTop();
            System.out.println("Player 1, please play a card or [Draw]"); // Asks player to play or draw
            computer.printHand(); // Print out hand to player (If computer, it will not print hand)
            int playerStep = 1; // Player step so program doesn't mess up, resets after each turn
            inputStatement = computer.returnCard(gamePile.topCardReturn(), 1);
            if(inputStatement.equals("Draw")) // If draw, then player will draw card, and have a card added to their hand
            {
              computer.drawCard(); // Draw card command played
              playerStep = 2; // Program is stepped again
              while(playerStep == 2)
              {
                gamePile.pileTop();
                System.out.println("Player 1, please play a card or [Pass]"); // Asks player to play or pass
                inputStatement = computer.returnCard(gamePile.topCardReturn(), 2);
                if(inputStatement.equals("Pass")) // If pass, goes to player 2
                {
                  playerStep = 3;
                  playerMove = 2;
                }
                else // Else if a card is actually palyed
                {
                  if(gamePile.pileCheck(inputStatement) && computer.checkCard(inputStatement)) // Checks pile for legal input, checks card for legal existance 
                  {
                    computer.playCard(inputStatement); // Plays card
                    gamePile.setPileValues(inputStatement);
                    if(inputStatement.substring(0,1).equals("W")) // If wild...
                    {
                      System.out.println("Please pick a new color: [R],[Y],[G],[B]"); // Player will be asked to input a color
                      wildInput = computer.returnWildColor();      
                      if(gamePile.wildColor(wildInput) && inputStatement.length() > 2) // Reads wild card to see if draw two or four, if none, then nothing happens
                      {
                        gamePile.setWildPileValues(wildInput+"0"); // Sets pile color to wild color
                        player2.drawForWild(inputStatement.substring(2)); // Opposite player draws cards
                        player2.printHand();
                      }
                      else gamePile.setWildPileValues(wildInput+"0"); // If no Draw Wild, then pile is just set to color
                    }
                    if(computer.handSizeZero() == 0|| player2.handSizeZero() == 0)
                    {
                      programStep = 2;
                    }
                    playerStep = 3; // Ends turn and switches to other player
                    playerMove = 2;
                  }
                  else
                  {
                    System.out.println("Invalid Entry"); // Invalid entry leads back to player
                    playerStep = 2;
                  }
                }
              }
            }
            else
            {
              if(gamePile.pileCheck(inputStatement) && computer.checkCard(inputStatement)) // Checks statement for if draw was never typed
              {
                computer.playCard(inputStatement); // All the same as above, just repeated in a different loop
                gamePile.setPileValues(inputStatement);
                if(inputStatement.substring(0,1).equals("W"))
                {
                  System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                  wildInput = computer.returnWildColor();
                  
                  if(gamePile.wildColor(wildInput) && inputStatement.length() > 2)
                  {
                    gamePile.setWildPileValues(wildInput+"0");
                    player2.drawForWild(inputStatement.substring(2));
                    player2.printHand();
                  }
                  else gamePile.setWildPileValues(wildInput+"0");
                }
                if(computer.handSizeZero() == 0|| player2.handSizeZero() == 0)
                {
                  programStep = 2;
                }
                playerStep = 3;
                playerMove = 2;
              }
              else
              {
                System.out.println("Invalid Entry");
                playerMove = 1;
              }
            }
          }
          else if(playerGame.equals("2"))
          {
            if(player1.handSizeZero() == 0 || player2.handSizeZero() == 0) // If any player's handsize is detected to be zero, immediately go to next step of program
            {
              programStep = 2;
            }
            gamePile.pileTop();
            System.out.println("Player 1, please play a card or [Draw]"); // Asks player to play or draw
            player1.printHand(); // Print out hand to player (If computer, it will not print hand)
            int playerStep = 1; // Player step so program doesn't mess up, resets after each turn
            inputStatement = in.next();
            if(inputStatement.equals("Draw")) // If draw, then player will draw card, and have a card added to their hand
            {
              player1.drawCard(); // Draw card command played
              playerStep = 2; // Program is stepped again
              while(playerStep == 2)
              {
                gamePile.pileTop();
                System.out.println("Player 1, please play a card or [Pass]"); // Asks player to play or pass
                inputStatement = in.next(); // Player input command
                if(inputStatement.equals("Pass")) // If pass, goes to player 2
                {
                  playerStep = 3;
                  playerMove = 2;
                }
                else // Else if a card is actually palyed
                {
                  if(gamePile.pileCheck(inputStatement) && player1.checkCard(inputStatement)) // Checks pile for legal input, checks card for legal existance 
                  {
                    player1.playCard(inputStatement); // Plays card
                    gamePile.setPileValues(inputStatement);
                    if(inputStatement.substring(0,1).equals("W")) // If wild...
                    {
                      System.out.println("Please pick a new color: [R],[Y],[G],[B]"); // Player will be asked to input a color
                      wildInput = in.next();      
                      if(gamePile.wildColor(wildInput) && inputStatement.length() > 2) // Reads wild card to see if draw two or four, if none, then nothing happens
                      {
                        gamePile.setWildPileValues(wildInput+"0"); // Sets pile color to wild color
                        player2.drawForWild(inputStatement.substring(2)); // Opposite player draws cards
                        player2.printHand();
                      }
                      else gamePile.setWildPileValues(wildInput+"0"); // If no Draw Wild, then pile is just set to color
                    }
                    if(player1.handSizeZero() == 0|| player2.handSizeZero() == 0)
                    {
                      programStep = 2;
                    }
                    playerStep = 3; // Ends turn and switches to other player
                    playerMove = 2;
                  }
                  else
                  {
                    System.out.println("Invalid Entry"); // Invalid entry leads back to player
                    playerStep = 2;
                  }
                }
              }
            }
            else
            {
              if(gamePile.pileCheck(inputStatement) && player1.checkCard(inputStatement)) // Checks statement for if draw was never typed
              {
                player1.playCard(inputStatement); // All the same as above, just repeated in a different loop
                gamePile.setPileValues(inputStatement);
                if(inputStatement.substring(0,1).equals("W"))
                {
                  System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                  wildInput = in.next();
                  
                  if(gamePile.wildColor(wildInput) && inputStatement.length() > 2)
                  {
                    gamePile.setWildPileValues(wildInput+"0");
                    player2.drawForWild(inputStatement.substring(2));
                    player2.printHand();
                  }
                  else gamePile.setWildPileValues(wildInput+"0");
                }
                if(player1.handSizeZero() == 0|| player2.handSizeZero() == 0)
                {
                  programStep = 2;
                }
                playerStep = 3;
                playerMove = 2;
              }
              else
              {
                System.out.println("Invalid Entry");
                playerMove = 1;
              }
            }
          }
          ///////////////////////////////////////////////
          while(playerMove == 2) // All the same as playermove 1, but without checking for computer player.
          {
            if(player1.handSizeZero() == 0|| player2.handSizeZero() == 0)
            {
              programStep = 2;
            }
            gamePile.pileTop();
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
                gamePile.pileTop();
                System.out.println("Player 2, please play a card or [Pass]");
                inputStatement = in.next();
                if(inputStatement.equals("Pass"))
                {
                  playerTwoStep = 3;
                  playerMove = 1;
                }
                else
                {
                  if(gamePile.pileCheck(inputStatement) && player2.checkCard(inputStatement))
                  {
                    player2.playCard(inputStatement);
                    gamePile.setPileValues(inputStatement);
                    if(inputStatement.substring(0,1).equals("W"))
                    {
                      System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                      wildInput = in.next();
                      if(gamePile.wildColor(wildInput) && inputStatement.length() > 2)
                      {
                        gamePile.setWildPileValues(wildInput+"0");
                        player1.drawForWild(inputStatement.substring(2));
                        player1.printHand();
                      }
                      else gamePile.setWildPileValues(wildInput+"0");
                    }
                    if(player1.handSizeZero() == 0|| player2.handSizeZero() == 0)
                    {
                      programStep = 2;
                    }
                    playerTwoStep = 3;
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
                gamePile.setPileValues(inputStatement);
                if(inputStatement.substring(0,1).equals("W"))
                {
                  System.out.println("Please pick a new color: [R],[Y],[G],[B]");
                  wildInput = in.next();
                  if(gamePile.wildColor(wildInput) && inputStatement.length() > 2)
                  {
                    gamePile.setWildPileValues(wildInput+"0");
                    player1.drawForWild(inputStatement.substring(2));
                    player1.printHand();
                  }
                  else gamePile.setWildPileValues(wildInput+"0");
                }
                if(player1.handSizeZero() == 0|| player2.handSizeZero() == 0)
                {
                  programStep = 2;
                }
                playerTwoStep = 3;
                playerMove = 1;
              }
              else
              {
                System.out.println("Invalid Entry");
                playerMove = 2;
              }
            }
          } 
          
          if(programStep == 2) //////////////////////////////////////////////////Program step two, after game is finished
          {
            System.out.println("test");
          }
        }
      } 
    }
  }
}