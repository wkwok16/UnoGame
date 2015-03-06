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
    String[] typeCard = {"Red", "Blue", "Green", "Yellow", "Wild", "Wild Draw 2", "Wild Draw 4"};
    return typeCard[type];
  }
  
  public int returnNumber()
  {
    return number;
  }
}