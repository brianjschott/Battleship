public class GameController {

  private Player playerOne, playerTwo, currentPlayer;
  public static final int GRID_ROWS = 8, GRID_COLS = 8;

  public GameController() {

    Player p1 = new Player("Brian");

    System.out.println("Please place your ships");

    p1.placeInitialShips();
  }

}