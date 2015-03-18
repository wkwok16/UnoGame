import java.util.*;
public class Computer extends Player
{
  private ArrayList<Card> hand = new ArrayList<Card>(); // Creates new hand arraylist
  public Computer() 
  {
    for(int i = 0; i < 7; i++)
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
    
  public String returnCard(String pileTopCard, int in)
  {
    String returnCard = "";
    if(pileTopCard.equals(""))
    {
      int randomCardChooser = ((int)(Math.random()*hand.size()));
      returnCard = hand.get(randomCardChooser).returnType() + hand.get(randomCardChooser).returnNumber();
      hand.remove(randomCardChooser);
      return returnCard;
    }
    else 
    {
      for(int i = 0; i < hand.size(); i++) // Goes through and looks for a playable card
      {
        if(pileTopCard.substring(0,1).equals(hand.get(i).returnType()))
        {
          returnCard = hand.get(i).returnType() + hand.get(i).returnNumber();
          hand.remove(i);
          return returnCard;
        }
      }
      for(int i = 0; i < hand.size(); i++) // If it cant find a matching letter, find a matching card
      {
        if(pileTopCard.substring(1).equals(hand.get(i).returnNumber()))
        {
          returnCard = hand.get(i).returnType() + hand.get(i).returnNumber();
          hand.remove(i);
          return returnCard;
        }
      }
      for(int i = 0; i < hand.size(); i++) // If it cant find a matching number either, return a wild
      {
        if(hand.get(i).returnType().substring(0,1).equals("W"))
        {
          returnCard = hand.get(i).returnType();
          hand.remove(i);
          return returnCard;
        }
      }
      if(in == 1)
      {
        return "Draw"; // Returns draw if it cant find anything that works
      }
      else return "Pass"; // Returns pass if it cant find a card at all
    }
  }
  
  public String returnWildColor()
  {
    return "W";
  }
}