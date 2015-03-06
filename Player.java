public class Player
{
  Hand playerHand = new Hand();
  public Player()
  {
  }
  
  String returnstuff()
  {
    playerHand.printHand();
    return "";
  }
}