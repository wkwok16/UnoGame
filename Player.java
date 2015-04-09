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
    if(drawState == 1)
    {
      System.out.println("The cards you drew from the player's WD" + wildCount + " were:");
      for(int i = (hand.size()-wildCount); i < hand.size(); i++)
      {
        System.out.print("["+hand.get(i).returnType()+hand.get(i).returnNumber()+"]");
      }
      drawState = 0;
      System.out.println();
    }
    reorganizeHand();
    System.out.println("Your cards are: ");
    for(int i = 0; i < hand.size(); i++)
    {
      System.out.print("["+hand.get(i).returnType()+hand.get(i).returnNumber()+"]");
    }
    System.out.println();
  }
  public void reorganizeHand()
  {
    ArrayList<Card> reorganizedHand = new ArrayList<Card>(); // Creates new hand arraylist
    String[] typeCard = {"R", "B", "G", "Y", "W", "WD2", "WD4"};
    for(int x = 0; x < 7; x++)
    {
      for(int i = 0; i < hand.size(); i++)
      {
        if(hand.get(i).returnType().equals(typeCard[x])) reorganizedHand.add(hand.get(i));
      }
    }
    hand = reorganizedHand;
  }
  public void printHandSize() // Test function to see size of hand
  {
    System.out.println(hand.size());
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
  // Unused for regular player class
  public String returnCard(String pilein, int in) // Automatic return card, to be used specifically in computer player
  {
    return "W";
  }
  public String returnWildColor() // Automatic color returner for computer player
  {
    return "W";
  }
}