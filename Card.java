public class Card
{
  private int type;
  private int number;
  public Card(int inType, int inNumber)
  {
    type = inType;
    number = inNumber;
  }
  
  public String returnType()
  {
    String[] typeCard = {"Red", "Blue", "Green", "Yellow", " Wild", " Wild Draw 2", " Wild Draw 4"};
    if(type >= 4)
    {
      int random = (int)(Math.random()*7);
      if(random >= 4) number = 0;
      return typeCard[random];
    }
    else return typeCard[type];
  }
  
  public int returnNumber()
  {
    return number;
  }
}