import java.util.Scanner;
public class Pile
{
  Scanner in = new Scanner(System.in); // Creates new scanner
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
  
  public boolean wildColor(String colorIn)
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
  
  public boolean pileCheck(String in)
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
    if(colorEqual || numberEqual || pilesize == 0)
    {
      setPileValues(in);
      pilesize++;
      return true;
    }
    if(in.substring(0,1).equals("W"))
    {
      setPileValues(in);
      pilesize++;
      return true;
    }
    else return false;
  }
}