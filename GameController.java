import java.util.Scanner;

public class GameController {

  private Player[] playerList;
  public static final int GRID_ROWS = 8, GRID_COLS = 8;
  public final int NUMBER_OF_PLAYERS = 2;
  public static int currentPlayerNum = 0;

  public void warnPlayer() {
    Scanner kb = new Scanner(System.in);
    System.out.println("Next player's turn! Please switch and press Space twice when ready.");
    kb.next();
    kb.next();
    clearScreen();
  }

  public Player getNextPlayer() {

    warnPlayer();

    if (currentPlayerNum == playerList.length - 1) {
      currentPlayerNum = 0;
    } else {
      currentPlayerNum++;
    }
    return playerList[currentPlayerNum];
  }

  // creating the GameController object starts the game
  public GameController() {

    // creates new Player objects at each spot in playerList
    playerList = new Player[NUMBER_OF_PLAYERS];
    for (int i = 0; i < playerList.length; i++) {
      playerList[i] = new Player(i);
    }

    //will fix for 3-4 player battleship, but I'm too lazy right now
    playerList[0].setOpponent(playerList[1]);
    playerList[1].setOpponent(playerList[0]);
  }

  // calls the placeInitialShips method of the Player class on all players
  public void shipPlacementPhase() {
    for (int i = 0; i < playerList.length; i++) {
      playerList[i].placeInitialShips();
    }
  }

  // @return: the winning player
  // function runs through the main game loop logic
  public int gamePhase() {

    boolean gameOver = false;
    Player currentPlayer = playerList[0];
    Scanner kb = new Scanner(System.in);
    // main game loop
    do {

      // player chooses coordinates
      System.out.print("Enter a column coordinate to blast ");
      int col = Tile.convertColumnLetter(kb.next().charAt(0));

      System.out.print("Enter a row coordinate to blast: ");
      int row = kb.nextInt();
      //add input validation for the above code


      Tile targetTile = currentPlayer.getOpponent().getGrid().getBoard()[row][col];

      if (targetTile.getIsBlasted()) {
        System.out.println("You already shot there before! 🤦");
      }
      else {
        System.out.println("Target locked...");
      }

      boolean isAHit = targetTile.isShipPresent();

      // if a ship is there, change isBlasted value on the Tile and lower that ship's
      if (isAHit && !targetTile.getIsBlasted()) {
        System.out.println("It's a hit!💥");
        
        //set the tile as blasted which updates icons
        targetTile.setIsBlasted(true);

        Ship s = targetTile.getShipPresent();
        
        //decrease ship health
        s.takeAHit();

        //if a ship is sunk
        if (!s.isStillFloating()) {
          System.out.println("You sunk a " + s.getShipType() + "!\t" + s);
        }

        
      }
      else {
        System.out.println("Splash! 💦");
      }

      if (!currentPlayer.getOpponent().anyShipsStanding()) { 
        System.out.println("Opponent has no more ships left!");
        break;
      }
      
      // warn the player that other player is up and to leave the table
      warnPlayer();
            
      currentPlayer = getNextPlayer();

    } while (!gameOver);
    return currentPlayerNum;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}