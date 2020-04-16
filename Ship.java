public class Ship {
  private Coord[] coordList;
  private Player player;
  private ShipTypes shipType; 
  private boolean isFloating;
  private int shipLength;
  private String shipIcon;
  private int shipHealth;
    
  public static int getShipLengthOfType(ShipTypes shipType) {
    switch (shipType) {
      case CARRIER:
        return 5;
      case BATTLESHIP:
        return 4;
      case CRUISER:
        return 3;
      case SUBMARINE:
        return 3;
      case DESTROYER:
        return 2;
      default:
        return 0;
    }
  }

  public String getShipIconOfType(ShipTypes shipType) {
    switch (shipType) {
      case CARRIER:
        return "🚢";
      case BATTLESHIP:
        return "🔫";
      case CRUISER:
        return "🛥️";
      case SUBMARINE:
        return "🔱";
      case DESTROYER:
        return "⛵";
      default:
        return "❓";
    }
  }

  public enum ShipTypes {
    CARRIER, BATTLESHIP, CRUISER, SUBMARINE, DESTROYER
  }

  // public static String[] getStringArrayOfShipTypes() {
  //   String[] shipList;

    
  // }

  public Ship(Coord[] coordList, Player player, ShipTypes shipType) {
    this.coordList = coordList;
    this.player = player;
    this.shipType = shipType;
    this.isFloating = true;
    
    //converts ENUM value of shipType into a length
    this.shipLength = getShipLengthOfType(shipType);
    this.shipIcon = getShipIconOfType(shipType);

    this.shipHealth = this.shipLength;
  }

  public Coord[] getCoordList() {
    return coordList;
  }

  public String toString() {
    return this.shipIcon;
  }

  public String getShipType() {
    return this.shipType.name();
  }

  public void takeAHit() {
    this.shipHealth -= 1;
  }

  public boolean isStillFloating() {
    if (this.shipHealth > 0 ) { return true;}
    return false;
  }
}