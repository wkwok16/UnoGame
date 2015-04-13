import java.util.*;
public class Player
{
  private ArrayList<Card> hand = new ArrayList<Card>(); // Creates new hand arraylist
  private int drawState = 0;
  private int wildCount = 0;
  public Player() // Creates new full 7 card hand at start of game
  {
    for(int i = 0; i < 7; i++)
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  public void printHand() // Prints full hand of cards
  {
    if(drawState == 1) // If card/cards were drawn...
    {
      if(wildCount == 1) System.out.println("The card you just drew was:"); // Checks if it was just a drawn card from player command or if it was a wild draw
      else System.out.println("The cards you drew from the player's WD" + wildCount + " were:"); // Displays different things depending on tat
      for(int i = (hand.size()-wildCount); i < hand.size(); i++) // Goes through hand for most recent cards drawn
      {
        System.out.print("["+hand.get(i).returnType()+hand.get(i).returnNumber()+"]"); // Displays
      }
      drawState = 0; // Ends the loop
      System.out.println();
    }
    reorganizeHand(); // Reorganizes hand before showing hand
    System.out.println("Your cards are: ");
    for(int i = 0; i < hand.size(); i++)
    {
      System.out.print("["+hand.get(i).returnType()+hand.get(i).returnNumber()+"]");
    }
    System.out.println();
  }
  public void reorganizeHand()
  {
    ArrayList<Card> reorganizedHand = new ArrayList<Card>(); // Creates new organizedhand arraylist to drop into place of actual hand after reorganization
    String[] typeCard = {"R", "B", "G", "Y", "W", "WD2", "WD4"}; // Card types for easy access in next loop
    for(int x = 0; x < 7; x++) // Goes through card type
    {
      for(int i = 0; i < hand.size(); i++) // Goes through hand and finds each type of card and orders it in same order as typeCard array
      {
        if(hand.get(i).returnType().equals(typeCard[x])) reorganizedHand.add(hand.get(i));
      }
    }
    hand = reorganizedHand; // replaces hand with organizedhand arraylist
  }
  public int handSizeZero() // Function to detect for size 0 hand
  {
    return hand.size();
  }
  public String playCard(String inText) // Plays card; gets card value from user input
  {
    for(int i = 0; i < hand.size(); i++)
    {
      if(inText.equals(hand.get(i).returnType()+hand.get(i).returnNumber())) // If card exists...
      {
        String returnText = "["+hand.get(i).returnType()+hand.get(i).returnNumber()+"] was played";
        hand.remove(i); // Removes card from hand arraylist
        return returnText;
      }
    }
    return "Invalid entry: Card not found"; // If card isn't found, returns this line
  }
  public void drawCard() // Adds a new card to the hand
  {
    hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    drawState = 1;
    wildCount = 1;
    this.printHand(); // Prints hand again so player sees their new card
  }
  public void drawForWild(String in) // Amount of cards to draw for a wild-draw card being played
  {
    drawState = 1;
    wildCount = Integer.parseInt(in);
    for(int i = 1; i <= Integer.parseInt(in); i++)
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  public boolean checkCard(String inText) // Checks if card exists in hand
  {
    for(int i = 0; i < hand.size(); i++)
    {
      if(inText.equals(hand.get(i).returnCard())) return true; // if card exists, return true
    }
    return false;
  }
}