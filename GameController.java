import java.util.Scanner;

public class GameController {

  private int currentPlayer;
  private Player[] playerList;
  public static final int GRID_ROWS = 8, GRID_COLS = 8;
  public final int NUMBER_OF_PLAYERS = 2;

  public GameController() {
    this.currentPlayer = 0;
    
    playerList = new Player[NUMBER_OF_PLAYERS];
    for (int i = 0; i < playerList.length; i++) {
      playerList[i] = new Player(i);
    }
  }

  public void shipPlacementPhase() {
    for (int i = 0; i < playerList.length; i++) {
      playerList[i].placeInitialShips();
    }
  }

  public int gamePhase() {
    
    boolean gameOver = false;
    //main game loop
    do {

      //player chooses coordinates

      //player's coordinates are converted to (r, c) values through a Tiles method

      //player's guess is compared against opponent's board

      //if a ship is there, change isBlasted value on the Tile and lower that ship's health

      //if a ship's health is going to 0, print out the "You sunk my <insert ship here>!" message

      //check if all ships are alive or not. if not, then return the current player

      //warn the player that other player is up and to leave the table

      //when player presses space twice, other player takes over (if currentPlayer isn't less than the number of players, the increase it; otherwise, set it back to 0)
    
    
    } while (!gameOver);
    return this.currentPlayer;
  }

  
}