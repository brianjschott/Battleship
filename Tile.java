public class Tile {
  private Ship shipPresent;
  private boolean isBlasted;
  private Coord tileCoord;
  
  public Tile(int x, int y) {
    this.shipPresent = null;
    this.isBlasted = false;
    this.tileCoord = new Coord(x, y);
  }

  public static int convertColumnLetter(char c) {
    return (int)c - 65;
  }

  public String toIcon(boolean isGuessGrid) {
    
    if (isBlasted) {
      if (shipPresent != null) {
        return "💥";
      }
      else {
        return "🌀";
      }
    }
    else {
      if (shipPresent != null && !isGuessGrid) {
        return shipPresent.toString();
      }
      else {
        return "🌊";      
      }
    }
  }


  public void resetTile() {
    this.shipPresent = null;
    this.isBlasted = false;
  }

  public Ship getShipPresent() {
    return this.shipPresent;
  }

  public void setShipPresent(Ship s) {
    shipPresent = s;
  }

  public boolean isShipPresent() {
    if (shipPresent != null) {
      return true;
    }
    else {
      return false;
    }
  }

  public Coord getTileCoord() {
    return this.tileCoord;
  }

  public void setIsBlasted(boolean b) {
    this.isBlasted = b;
  }

  public boolean getIsBlasted() {
    return this.isBlasted;
  }


}