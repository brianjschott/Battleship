import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

  private Grid myGrid;
  private ArrayList<Ship> myShipList;
  private String playerName;
  private int playerNumber;
  private Player opponent;

  public Player(int pNum) {

    this.playerNumber = pNum;
    this.playerName = setPlayerName();

    this.myGrid = new Grid(GameController.GRID_ROWS, GameController.GRID_COLS);

    this.myShipList = new ArrayList<Ship>();

  }

  //@param: a Player object
  //creates a reference to the opposing Player object
  public void setOpponent(Player o) {
    this.opponent = o;
  }

  public Player getOpponent() {
    return this.opponent;
  }

  public Grid getGrid() {
    return myGrid;
  }

  //draws player's side of the board
  public void drawSideOfBoard() {
    System.out.println("Your Grid: ");
    this.getGrid().viewBoard(false);
    System.out.println("Opponent's Grid: ");
    this.getOpponent().getGrid().viewBoard(true);
  }

  public void placeInitialShips() {
    
    System.out.println(this.playerName + ", please place your ships.");
    
    Scanner kb = new Scanner(System.in);

    // using values() I can convert an enum to an array, and fill it in with the
    // enum's values
    Ship.ShipTypes[] types = Ship.ShipTypes.values();
    // now I can iterate over each ship type
    for (Ship.ShipTypes shipType : types) {
      int startX = 0, startY = 0;
      int endX = 0, endY = 0;

      int shipLength = Ship.getShipLengthOfType(shipType);
      // while loop ensures I don't move on until ship is placed
      Coord[] cList = new Coord[shipLength];
      Coord startCoord, endCoord;

      boolean validShipPlacement, isCorrectLength;

      do {
        System.out.println("Placing the " + shipType);
        this.getGrid().viewBoard(false);

        //user inputs column and row values, they're converted to start/end x values
        System.out.print("Enter a column coordinate of start of ship: ");
        startX = Tile.convertColumnLetter(kb.next().toUpperCase().charAt(0));

        System.out.print("Enter a row coordinate of start: ");
        startY = kb.nextInt();

        System.out.print("Enter a column coordinate of end of ship: ");
        endX = Tile.convertColumnLetter(kb.next().toUpperCase().charAt(0));

        System.out.print("Enter a row coordinate of end: ");
        endY = kb.nextInt();

        //stores start and end as Coord objects
        startCoord = new Coord(startX, startY);
        endCoord = new Coord(endX, endY);

        //gets a list of all coords between that start and end value
        cList = Coord.getCoordList(startCoord, endCoord);

        // checks to see if placement is overlapping another ship or is off the grid
        validShipPlacement = myGrid.isValidShipPlacement(cList, myShipList);

        // ensure that the ship is the correct length
        isCorrectLength = (startCoord.getDistance(endCoord) == Ship.getShipLengthOfType(shipType));

        System.out.println("Is ship correct length: " + isCorrectLength);

      //loop until ship placed on grid, not overlapping anyone, and is a correct length
      } while (!validShipPlacement || !isCorrectLength);

      // checks to ensure a bad ship of length 0 doesn't get placed
      if (shipLength != 0) {
        myShipList.add(new Ship(cList, this, shipType));
        this.getGrid().updateBoard(myShipList);
      }
    }

    System.out.println("Ships correctly placed!");
  }

  public String getPlayerName() {
    return this.playerName;
  }

  public String setPlayerName() {
    
    String name = "";
    Scanner kb = new Scanner(System.in);
    do {
      
      System.out.print("Please enter a name: ");
      name = kb.nextLine();

    } while (name.equals(""));


    return name;

  }

  public boolean anyShipsStanding() {
    for (Ship s : this.myShipList) {
      if (s.isStillFloating()) {
        return true;
      }
    }
    return false;
  }
}