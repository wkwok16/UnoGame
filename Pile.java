public class Pile
{
  private int pilesize = 0; 
  private String pileColor = "";
  private String pileNumber = "";
  public Pile()
  {
  }
  
  public int pileSizeReturn() // Returns size of pile to check if first turn
  {
    return pilesize;
  }
  
  public String pileColorReturn() // Returns color of pile for next turn's check
  {
    return pileColor;
  }
  
  public void setPileValues(String in) // Sets color of pile after card is played
  {
    pileColor = in.substring(0,1);
    pileNumber = in.substring(1);
  }
  
  public void setWildPileValues(String in) // Sets values for wilds if input is correctly input...
  {
    if(in.equals("R0") ||
       in.equals("Y0") ||
       in.equals("G0") ||
       in.equals("B0"))
    {
      pileColor = in.substring(0,1);
      pileNumber = in.substring(1);
    }
    else  // otherwise sets a default value
    {
      System.out.println("Invalid entry for color detected. Setting to default color, RED");
      pileColor = "R";
      pileNumber = in.substring(1);
    }
  }
  
  public boolean wildColor(String colorIn) // Returns true or false if the input value is correct or not, to detect user input failure
  {
    if(colorIn.equals("R") ||
       colorIn.equals("Y") ||
       colorIn.equals("G") ||
       colorIn.equals("B"))
    {
      return true;
    }
    return false;   
  }
  
  public boolean pileCheck(String in) // Checks what the top of the pile is, and if the input card is equal to it in either color or value
  {
    boolean colorEqual = false;
    boolean numberEqual = false;
    if(in.substring(0,1).equals(pileColor))
    {
      colorEqual = true;
    }
    if(in.substring(1).equals(pileNumber))
    {
      numberEqual = true;
    }
    if(colorEqual || numberEqual || pilesize == 0 || in.substring(0,1).equals("W")) // If no cards have yet been placed in the pile, it returns true, so the first player can play a card
    {
      setPileValues(in);
      pilesize++;
      return true;
    }
    else return false;
  }
}