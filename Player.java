import java.util.*;
public class Player
{
  private ArrayList<Card> hand = new ArrayList<Card>(); // Creates new hand arraylist
  public Player() // Creates new full 7 card hand at start of game
  {
    for(int i = 0; i < 7; i++)
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  
  public void printHand() // Prints full hand of cards
  {
    for(int i = 0; i < hand.size(); i++)
    {
      System.out.print("["+hand.get(i).returnType()+hand.get(i).returnNumber()+"]");
    }
    System.out.println();
  }
  
  public boolean handSizeZero()
  {
    if(hand.size() == 0)
    {
      return true;
    }
    else return false;
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
  
  public void drawForWild(String in)
  {
    if(in.equals("2"))
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1))); 
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
    else if(in.equals("4"))
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  
  public boolean checkCard(String inText)
  {
    for(int i = 0; i < hand.size(); i++)
    {
      if(inText.equals(hand.get(i).returnCard())) // If card exists...
      {
        return true;
      }
    }
    return false;
  }
  
  public String returnCard()
  {
    return "W";
  }
  
  public String returnWildColor()
  {
    return "W";
  }
}