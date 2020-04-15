import java.util.Scanner;

class Main {
  
  private static boolean gameOver;
  private static int winningPlayer;
  
  
  public static void main(String[] args) {
    
    gameOver = false;
    Scanner kb = new Scanner(System.in);
    System.out.println("⚓\tBATTLESHIP\t⚓");

    while (!gameOver) {
      GameController g = new GameController();
      g.shipPlacementPhase();
      winningPlayer = g.gamePhase();

      System.out.println("Congratulations! Player " + winningPlayer + " has won!");
      
      System.out.print("Play again? (Y/N)");
      String choice = kb.nextLine();

      if (choice.toUpperCase().equals("N")) {
        gameOver = true;
      }
      else {
        gameOver = false;
      }
    }
  }
}