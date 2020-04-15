public class Coord {
  private int x;
  private int y;
  
  public Coord(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  public boolean matches(Coord c) {
    if (this.getX() == c.getX() && this.getY() == c.getY()) {
      return true;
    }
    return false;
  }

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


  public int getDistance(Coord c) {
    if (this.isHorizontal(c)) {
      return Math.abs(this.getX() - c.getX()) + 1;
    }
    else {
      return Math.abs(this.getY() - c.getY()) + 1;
    }
  }

  public boolean isHorizontal(Coord c) {
    if (this.getX() == c.getX()) {
      return false;
    }
    else {
      return true;
    }
  }

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

  public String toString() {
    return "(" + this.x + ", " + this.y + ")";
  }
}
