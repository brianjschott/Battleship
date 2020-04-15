import java.util.ArrayList;

public class Grid {
  private Tile[][] board;
  private int rows, cols;

  public Grid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.board = new Tile[this.rows][this.cols];
    this.initializeBoard();
  }

  public void initializeBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = new Tile(i, j);
      }
    }
  }

  public void resetBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j].resetTile();
      }

    }
  }

  public void viewBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + "\t");
      }
    System.out.println();
    System.out.println();
    }
  }

  public int getNumRows() {
    return this.rows;
  }

  public int getNumCols() {
    return this.cols;
  }

  public boolean isValidShipPlacement(Coord[] cList, ArrayList<Ship> myShipList) {
    
    //check every coord in pending ship
    for (Coord c1 : cList) {
      //check every ship in current ship list
      for (int i = 0; i < myShipList.size(); i++) {

        //checks all coords in each ship in the list
        Coord[] shipCoordList = myShipList.get(i).getCoordList();
        for (Coord c2 : shipCoordList) {
          if (c1.matches(c2)) {
            System.out.println("Overlaps another ship at " + c1);
            return false;
          }
        }
      }
      int x = c1.getX();
      int y = c1.getY();

      if (x < 0 || x > this.cols || y < 0 || y < this.rows) {
        System.out.println("Not placed on grid correctly");
        return false;
      }
    }

    return true;

  }

}