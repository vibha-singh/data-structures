package main.battleship.game;

import lld.dec2025.battleship.display.ConsoleDisplayStrategy;
import lld.dec2025.battleship.display.DisplayStrategy;
import lld.dec2025.battleship.factory.ShipFactory;
import lld.dec2025.battleship.game.state.GameOverState;
import lld.dec2025.battleship.game.state.GameState;
import lld.dec2025.battleship.game.state.PlayingState;
import lld.dec2025.battleship.game.state.SetupState;
import lld.dec2025.battleship.model.A_Position;
import lld.dec2025.battleship.model.B_Cell;
import lld.dec2025.battleship.model.IShip;
import lld.dec2025.battleship.player.Player;

public abstract class BattleshipGame {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player opponent;
    private GameState currentState;
    protected final DisplayStrategy displayStrategy;
    protected final ShipFactory shipFactory;

    public BattleshipGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.opponent = player2;
        this.currentState = new SetupState();
        this.displayStrategy = new ConsoleDisplayStrategy();
        this.shipFactory = new ShipFactory();
    }

    public void start() {
        currentState.handle(this);
    }

    public void setupPhase() {
        System.out.println("=== BATTLESHIP GAME ===\n");
        setupPlayerShips(player1);
        setupPlayerShips(player2);
        currentState = new PlayingState();
        currentState.handle(this);
    }

    public void playTurn() {
        while (!isGameOver()) {
            System.out.println("\n=== " + currentPlayer.getName() + "'s Turn ===");
            System.out.println("\nYour Board:");
            displayStrategy.displayBoard(currentPlayer.getBoard(), false);
            System.out.println("\nOpponent's Board:");
            displayStrategy.displayBoard(opponent.getBoard(), true);

            A_Position attackPos = currentPlayer.chooseAttackPosition(opponent.getBoard());
            boolean hit = opponent.getBoard().attack(attackPos);

            if (hit) {
                B_Cell cell = opponent.getBoard().getCell(attackPos.getRow(), attackPos.getCol());
                IShip hitShip = cell.getShip();
                System.out.println("HIT!");
                if (hitShip != null && hitShip.isSunk()) {
                    System.out.println("You sunk the " + hitShip.getType() + "!");
                }
            } else {
                System.out.println("MISS!");
            }

            switchPlayers();
        }

        currentState = new GameOverState();
        currentState.handle(this);
    }

    private void switchPlayers() {
        Player temp = currentPlayer;
        currentPlayer = opponent;
        opponent = temp;
    }

    private boolean isGameOver() {
        return player1.hasLost() || player2.hasLost();
    }

    public void endGame() {
        Player winner = player1.hasLost() ? player2 : player1;
        System.out.println("\n=== GAME OVER ===");
        System.out.println(winner.getName() + " WINS!");
    }

    protected abstract void setupPlayerShips(Player player);

    public abstract void displayBoards();
}
