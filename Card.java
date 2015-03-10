public class Card
{
  private int type;
  private int number;
  public Card(int inType, int inNumber) // Creates new Card element with a 'type' (color or wild) and 'number' (1-9)
  {
    type = inType;
    number = inNumber;
  }
  
  public String returnType() // Grabs the type of card input and returns it as a string
  {
    String[] typeCard = {"Red", "Blue", "Green", "Yellow", "Wild", "Wild Draw 2", "Wild Draw 4"};
    if(type >= 4)
    {
      int random = (int)(Math.random()*7); // Extra reset for wilds, so they appear less often
      if(random >= 4) number = 0;
      return typeCard[random];
    }
    else return typeCard[type];
  }
  
  public String returnNumber() // Returns number of card as a string
  {
    if(number != 0) return " "+number;
    else return "";
  }
}