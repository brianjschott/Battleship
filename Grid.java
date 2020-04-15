import java.util.ArrayList;

public class Grid {
  //a Grid stores board, a 2D array of Tiles
  private Tile[][] board;
  private int rows, cols;

  public Grid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.board = new Tile[this.rows][this.cols];
    this.initializeBoard();
  }

  //creates Tile objects at each space on the board
  public void initializeBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = new Tile(i, j);
      }
    }
  }

  //calls resetTile on all spaces
  //used at the end of a game to restart
  public void resetBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j].resetTile();
      }

    }
  }

  //@param: true if it's the opponent's view ("the guess board") and false if not
  //displays all grid spaces and adds tabs between them
  public void viewBoard(boolean isGuessGrid) {

    char columnLetter = 'A';

    //prints out column letters
    System.out.print("\t");

    for (int i = 0; i < board.length; i++) {
      System.out.print((char)(columnLetter + i));
      System.out.print("\t");
    }

    System.out.println();
    System.out.println();
    
    for (int i = 0; i < board.length; i++) {
      //prints row number then the rest of row
      System.out.print("" + i + "\t");
      for (int j = 0; j < board[i].length; j++) {
        
        System.out.print(board[i][j].toIcon(isGuessGrid) + "\t");
      }
    System.out.println();
    System.out.println();
    }
  }


  //@param: the current ship list
  //updates the Ship references so each Tile knows what ship (if any) is there
  public void updateBoard(ArrayList<Ship> shipList) {
    for (Ship s: shipList) {
      for (Coord c: s.getCoordList()) {
        this.board[c.getY()][c.getX()].setShipPresent(s);
      }
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

      if (x < 0 || x > this.cols || y < 0 || y > this.rows) {
        System.out.println("Not placed on grid correctly");
        return false;
      }
    }

    return true;

  }

}