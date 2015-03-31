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
  
  public void printHand() // Prints full hand of cards
  {
    for(int i = 0; i < handComputer.size(); i++)
    {
      System.out.print("["+handComputer.get(i).returnType()+handComputer.get(i).returnNumber()+"]");
    }
    System.out.println();
  }
  
  public void printHandSize() // Test function to see size of hand
  {
    System.out.println(handComputer.size());
  }
  
  public int handSizeZero() // Function to detect for size 0 hand
  {
    return handComputer.size();
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
    int pickerStep = 1;
    
    /*
   cardOutput = handComputer.get(0).returnType() + handComputer.get(0).returnNumber();
   return cardOutput;
    */
    
    
    for(int i = 0; i < handComputer.size(); i++) // Goes through and looks for a playable card
    {
      if(pileTopCard.equals(""))
      {
        returnCard += handComputer.get(i).returnType() + handComputer.get(i).returnNumber();
       
        return returnCard;
      }
      else if(pileTopCard.substring(0,1).equals(handComputer.get(i).returnType()) || pileTopCard.substring(1).equals(handComputer.get(i).returnNumber()))
      {
        returnCard += handComputer.get(i).returnType() + handComputer.get(i).returnNumber();
        
        return returnCard;
      }
    }
    for(int i = 0; i < handComputer.size(); i++) // If it cant find a matching number either, return a wild
    {
      if(handComputer.get(i).returnType().substring(0,1).equals("W"))
      {
        returnCard += handComputer.get(i).returnType();
        
        return returnCard;
      }
    }
    
    if(in == 1)
    {
      return "Draw"; // Returns draw if it cant find anything that works
    }
    
    else return "Pass"; // Returns pass if it cant find a card at all
    
    
  }
  public boolean checkCard(String inText) // Checks if card exists in hand
  {
    for(int i = 0; i < handComputer.size(); i++)
    {
      if(inText.equals(handComputer.get(i).returnCard())) // If card exists...
      {
        return true;
      }
    }
    return false;
  }
  
  public String returnWildColor()
  {
    return "G";
  }
}