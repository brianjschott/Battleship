import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Player {

  private Grid myGrid;
  private ArrayList<Ship> myShipList;
    
  public Player() {
    myGrid = new Grid(GameController.GRID_ROWS, GameController.GRID_COLS);
    myShipList = placeInitialShips();
  }

  public Grid getGrid() {
    return myGrid;
  }

  public Ship[] placeInitialShips() {
    ArrayList<Ship> shipList = new ArrayList<Ship>();
    Scanner kb = new Scanner(System.in);
    
    //using values() I can convert an enum to an array, and fill it in with the enum's values
    ShipTypes types = ShipTypes.values();
    //now I can iterate over each enum
    for (ShipTypes shipType : types) {
      boolean shipPlaced = false;
      int x = 0, y = 0;
      //while loop ensures I don't move on until ship is placed
      while (!shipPlaced) {
        
        System.out.println("Placing the " + shipType);
        this.getGrid().viewBoard();

        System.out.print("Enter a x coordinate: ");
        x = kb.nextInt();

        System.out.print("Enter a y coordinate: ");
        y = kb.nextInt();


      }
    }

    return shipList;

  }



}