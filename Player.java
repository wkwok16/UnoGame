public class Player
{
  Hand playerHand = new Hand();
  public Player()
  {
  }
  
  public String returnstuff()
  {
    playerHand.printHand();
    return "";
  }
}