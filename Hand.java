import java.util.*;

public class Hand
{
  private ArrayList<Card> hand = new ArrayList<Card>();
  public Hand()
  {
    for(int i = 0; i < 7; i++)
    {
      hand.add(new Card((int)(Math.random()*7), (int)(Math.random()*9+1)));
    }
  }
  
  public void printHand()
  {
    for(int i = 0; i < hand.size(); i++)
    {
      System.out.print("["+hand.get(i).returnType()+"-"+hand.get(i).returnNumber()+"]");
    }
    System.out.println();
  }
}