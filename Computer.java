import java.util.*;
public class Computer extends Player
{
  private ArrayList<Card> handComputer = new ArrayList<Card>(); // Creates new hand arraylist
  public Computer() 
  {
    for(int i = 0; i < 7; i++)
    {
      handComputer.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  
    public String playCard(String inText) // Plays card; gets card value from user input
  {
    for(int i = 0; i < handComputer.size(); i++)
    {
      if(inText.equals(handComputer.get(i).returnType()+handComputer.get(i).returnNumber())) // If card exists...
      {
        String returnText = "["+handComputer.get(i).returnType()+handComputer.get(i).returnNumber()+"] was played";
        handComputer.remove(i); // Removes card from hand arraylist
        return returnText;
      }
    }
    return "Invalid entry: Card not found"; // If card isn't found, returns this line
  }
    
  public String returnCard(String pileTopCard, int in)
  {
    String returnCard = "";
    if(pileTopCard.equals(""))
    {
      int randomCardChooser = (((int)(Math.random()*handComputer.size())));
      returnCard = handComputer.get(randomCardChooser).returnType() + handComputer.get(randomCardChooser).returnNumber();
      handComputer.remove(randomCardChooser);
      return returnCard;
    }
    else 
    {
      for(int i = 0; i < handComputer.size(); i++) // Goes through and looks for a playable card
      {
        if(pileTopCard.substring(0,1).equals(handComputer.get(i).returnType()))
        {
          returnCard = handComputer.get(i).returnType() + handComputer.get(i).returnNumber();
          handComputer.remove(i);
          return returnCard;
        }
      }
      for(int i = 0; i < handComputer.size(); i++) // If it cant find a matching letter, find a matching card
      {
        if(pileTopCard.substring(1).equals(handComputer.get(i).returnNumber()))
        {
          returnCard = handComputer.get(i).returnType() + handComputer.get(i).returnNumber();
          handComputer.remove(i);
          return returnCard;
        }
      }
      for(int i = 0; i < handComputer.size(); i++) // If it cant find a matching number either, return a wild
      {
        if(handComputer.get(i).returnType().substring(0,1).equals("W"))
        {
          returnCard = handComputer.get(i).returnType();
          handComputer.remove(i);
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