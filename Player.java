import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Player {

  private Grid myGrid;
  private ArrayList<Ship> myShipList;

  private String playerName;  
  
  public Player(String playerName) {
    
    this.playerName = playerName;
    
    this.myGrid = new Grid(GameController.GRID_ROWS, GameController.GRID_COLS);

    this.myShipList = new ArrayList<Ship>();
    
    this.myShipList = placeInitialShips();
  }

  public Grid getGrid() {
    return myGrid;
  }

  public ArrayList<Ship> placeInitialShips() {
    ArrayList<Ship> shipList = new ArrayList<Ship>();
    Scanner kb = new Scanner(System.in);
    
    //using values() I can convert an enum to an array, and fill it in with the enum's values
    Ship.ShipTypes[] types = Ship.ShipTypes.values();
    //now I can iterate over each ship type
    for (Ship.ShipTypes shipType : types) {
      boolean shipPlaced = false;
      int startX = 0, startY = 0;
      int endX = 0, endY = 0;

      int shipLength = Ship.getShipLengthOfType(shipType);
      int placesLeft = shipLength;
      //while loop ensures I don't move on until ship is placed
      Coord[] cList = new Coord[shipLength];

      do {
        System.out.println("Placing the " + shipType);
        this.getGrid().viewBoard();

        System.out.print("Enter a x coordinate of start: ");
        startX = kb.nextInt();

        System.out.print("Enter a y coordinate of start: ");
        startY = kb.nextInt();

        System.out.print("Enter a x coordinate of end: ");
        endX = kb.nextInt();

        System.out.print("Enter a y coordinate of end: ");
        endY = kb.nextInt();


        cList = Coord.getCoordList(new Coord(startX, startY), new Coord(endX, endY));
        
        
      } while(!myGrid.isValidShipPlacement(cList, myShipList));

      //checks to ensure a bad ship of length 0 doesn't get placed
      if (shipLength != 0) {
        shipList.add(new Ship(cList, this, shipType));
      }
    }

    System.out.println("Ships correctly placed!");
    return shipList;

  }


  public String getPlayerName() {
    return this.playerName;
  }

}