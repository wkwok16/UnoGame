public class Card
{
  private int type;
  private int number;
  private String returnTypeString = "";
  public Card(int inType, int inNumber) // Creates new Card element with a 'type' (color or wild) and 'number' (1-9)
  {
    type = inType;
    number = inNumber;

    String[] typeCard = {"R", "B", "G", "Y", "W", "WD2", "WD4"};
    if(type >= 4)
    {
      int random = (int)(Math.random()*7); // Extra reset for wilds, so they appear less often
      if(random >= 4) number = 0;
      returnTypeString = typeCard[random];
    }
    else returnTypeString = typeCard[type];
  }
  
  public String returnType() // Grabs the type of card input and returns it as a string
  {
    return returnTypeString;
  }
  
  public String returnNumber() // Returns number of card as a string
  {
    if(number != 0) return ""+number;
    else return "";
  }
  
  public String returnCard()
  {
    return returnType()+returnNumber();
  }
}