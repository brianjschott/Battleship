public class Coord {
  private int x;
  private int y;
  
  public Coord(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  //@param: a Coord to compare against
  //@return: true if the coordinate's x and y values are a match, false if not
  public boolean matches(Coord c) {
    if (this.getX() == c.getX() && this.getY() == c.getY()) {
      return true;
    }
    return false;
  }

  //get and set methods for x and y
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  //@param: a Coordinate object to compare against
  //@return: integer represneting the number of units between two Coords (inclusive of each endpoint)

  public int getDistance(Coord c) {
    if (this.isHorizontal(c)) {
      return Math.abs(this.getX() - c.getX()) + 1;
    }
    else {
      return Math.abs(this.getY() - c.getY()) + 1;
    }
  }

  //@param: a Coordinate to compare against
  //@return: true if the two coordinates form a horizontal line; false if not
  public boolean isHorizontal(Coord c) {
    if (this.getX() == c.getX()) {
      return false;
    }
    else {
      return true;
    }
  }

  //@param: two coordiantes
  //@return: a list of all the Coords that include and are between those two coords (uses a call to isHorizontal to see which way they form)
  public static Coord[] getCoordList(Coord c1, Coord c2) {
    int n = c1.getDistance(c2);
    Coord[] cList = new Coord[n];

    //c1 and c2 are the ends of the coords list
    cList[0] = c1;
    cList[cList.length - 1] = c2;

    //fills in the blanks between both ends for horizontal ships
    int startPoint = -1;

    if (c1.isHorizontal(c2)) {
      System.out.println("Horizontal ship");

      //checks which coordinate is first
      if (c1.getX() < c2.getX()) {
        startPoint = c1.getX();
      }
      else {
        startPoint = c2.getX();
      }

      for (int i = 1; i < cList.length - 1; i++) {
        cList[i] = new Coord(startPoint + i, c1.getY());
      }
    }

    //fills in blanks for vertical ships
    else {
      System.out.println("Vertical ship");  
      
      //checks which coordinate is first 
      if (c1.getY() < c2.getY()) {
        startPoint = c1.getY();
      }
      else {
        startPoint = c2.getY();
      }
      for (int i = 1; i < cList.length - 1; i++) {
        cList[i] = new Coord(c1.getX(), startPoint + i);
      }

    }
    System.out.println("Coordinate list is ");
    for (Coord c : cList) {
      System.out.println(c);
    }
    return cList;
  }

  //@return: the String form of the  Coord in the format of (x, y)
  public String toString() {
    return "(" + this.x + ", " + this.y + ")";
  }
}
