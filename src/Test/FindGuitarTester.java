package Test;
import java.util.Iterator;
import java.util.List;
import model.*;
public class FindGuitarTester {

  public static void main(String[] args) {
    Inventory inventory = new Inventory();
    initializeInventory(inventory);
    GuitarSpec testGuitar = new GuitarSpec("MakerA", "FolkGuitar", "6", "wood","wood");
    List matchingGuitars = inventory.search(testGuitar);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("You might like these guitars:");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
                guitar.getSerialNumber() + " " + spec.getBuilder() + " " +
                spec.getType() + " guitar:\n     " +
                spec.getBackWood() + " back and sides,\n     " +
                spec.getTopWood() + " top.\n  You can have it for only $" +
                guitar.getPrice() + "!\n  ----");
            }
    } else {
      System.out.println("对不起，没有您要找的吉他");
    }
  }

  
private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("001", "3200元", 
      new GuitarSpec("MakerA", "FolkGuitar", "6","wood","wood"));
    inventory.addGuitar("V95693", "1499.95", 
      new GuitarSpec("Builder.FENDER", "Stratocastor", "Type.ELECTRIC", 
                     "Wood.ALDER", "Wood.ALDER"));
  }  
 

}
