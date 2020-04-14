public class Tile {
  private Ship shipPresent;
  private boolean isBlasted;
  private Coord tileCoord;
  
  public Tile(int x, int y) {
    this.shipPresent = null;
    this.isBlasted = false;
    this.tileCoord = new Coord(x, y);
  }

  public String toString() {
    if (isBlasted && shipPresent != null) {
      return "💥";
    }
    else if (isBlasted && shipPresent == null) {
      return "🌀";
    }
    else if (!isBlasted && shipPresent != null) {
      return "🚢";
    }
    else {
      return "🌊";
    }
  }

  public void resetTile() {
    this.shipPresent = null;
    this.isBlasted = false;
  }


}