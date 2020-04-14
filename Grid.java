public class Grid {
  private Tile[][] board;
  private int rows, cols;

  public Grid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.board = new Tile[this.rows][this.cols];
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
        System.out.print(board[i][j]);
      }
    System.out.println();
    }
  }


}