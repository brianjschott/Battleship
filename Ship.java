public class Ship {
  private Coord[] coordList;
  private Player player;
  private ShipTypes shipType; 
  private boolean isFloating;
  
  public enum ShipTypes {
    CARRIER, BATTLESHIP, CRUISER, SUBMARINE, DESTROYER
  }

  public Ship(Coord[] coordList, Player player, ShipTypes shipType) {
    this.coordList = coordList;
    this.player = player;
    this.shipType = shipType;
    this.isFloating = true;
  }
  
  
}