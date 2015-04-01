import java.util.*;
public class Computer
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
    System.out.println("The computer is playing...");
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
        System.out.println("The computer has " + handComputer.size() + " cards left.");
        return returnText;
      }
    }
    return "Invalid entry: Card not found"; // If card isn't found, returns this line
  }
  public String returnCard(String pileTopCard, int in)
  {
    String returnCard = "";
    int pickerStep = 1;
    for(int i = 0; i < handComputer.size(); i++) // Goes through and looks for a playable card
    {
      if(pileTopCard.equals("")) // First turn just picks the first card in hand
      {
        returnCard += handComputer.get(i).returnType() + handComputer.get(i).returnNumber();
        return returnCard;
      }
      else if(pileTopCard.substring(0,1).equals(handComputer.get(i).returnType()) || pileTopCard.substring(1).equals(handComputer.get(i).returnNumber()))
      { // Looks for same type or number
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
  public void drawCard() // Adds a new card to the hand
  {
    handComputer.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
  }
  public void drawForWild(String in) // Amount of cards to draw for a wild-draw card being played
  {
    for(int i = 1; i <= Integer.parseInt(in); i++)
    {
      handComputer.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  public String returnWildColor()
  {
    int[] colorCount = new int[4]; // R,G,B,Y // Created new arraylist of ints to count the amount of each color in hand
    int colorGreatest = 0;
    int colorCountGreatest = 0;
    for(int i = 0; i < handComputer.size(); i++) // Counts each color and adds it to the array
    {
      if(handComputer.get(i).returnType().equals("R")) colorCount[0]++;
      else if(handComputer.get(i).returnType().equals("G")) colorCount[1]++;
      else if(handComputer.get(i).returnType().equals("B")) colorCount[2]++;
      else if(handComputer.get(i).returnType().equals("Y")) colorCount[3]++;
    }
    for(int i = 0; i < colorCount.length; i++) // Figures out which color is the greatest and then sets that as the main color greatest
    {
      if(colorCount[i] > colorCountGreatest)
      {
        colorCountGreatest = colorCount[i];
        colorGreatest = i;
      }
    }
    if(colorGreatest == 0) return "R"; // Picks greatest amount of color in hand. 
    else if(colorGreatest == 1) return "G";
    else if(colorGreatest == 2) return "B";
    else if(colorGreatest == 3) return "Y";
    else return "R";
  }
}