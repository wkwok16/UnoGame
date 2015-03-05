//Uno Game
//William Kwok

import java.util.Scanner;
public class UnoGameMain
{
  public static void main(String[] args)
  {
    int programStep = 0; // Step for simple turn executions for program
    Player computer = new Computer();
    Player startPlayer1 = new Player();
    Player startPlayer2 = new Player();
    Player player1 = new Player();
    Player player2 = new Player();
    while(programStep == 0)
    {
      Scanner in = new Scanner(System.in);
      System.out.println("Do you want to play with a friend or a computer player? Type 1 for computer and 2 for friend");
      int playerGame = in.nextInt();
      if(playerGame == 1) // If single player, set player1 and player2 to computer and a player
      { 
        player1 = computer;
        player2 = startPlayer1;
        programStep = 1;
      }
      else if(playerGame == 2) // If double player, set player1 and player2 to player and player
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
        
      }
      
    }
  }
}