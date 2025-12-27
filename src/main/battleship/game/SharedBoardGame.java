package main.battleship.game;

import lld.dec2025.battleship.model.A_Position;
import lld.dec2025.battleship.model.IShip;
import lld.dec2025.battleship.model.SharedBoard;
import lld.dec2025.battleship.model.enums.Direction;
import lld.dec2025.battleship.model.enums.ShipType;
import lld.dec2025.battleship.player.Player;
import lld.dec2025.battleship.player.TerritorialPlayer;

import java.util.Random;

public class SharedBoardGame  extends BattleshipGame {
    private final SharedBoard sharedBoard;

    public SharedBoardGame(TerritorialPlayer player1, TerritorialPlayer player2) {
        super(player1, player2);
        this.sharedBoard = new SharedBoard(10);
    }

    @Override
    protected void setupPlayerShips(Player player) {
        TerritorialPlayer territorialPlayer = (TerritorialPlayer) player;
        System.out.println("\n" + player.getName() + " - Placing ships in " + territorialPlayer.getTerritory());

        Random random = new Random();

        for (ShipType type : ShipType.values()) {
            IShip ship = shipFactory.createShip(type);
            boolean placed = false;

            while (!placed) {
                int row = random.nextInt(10);
                int col = random.nextInt(10);
                Direction direction = random.nextBoolean() ? Direction.HORIZONTAL : Direction.VERTICAL;

                // Place only in player's territory
                placed = sharedBoard.placeShipInTerritory(
                        ship,
                        new A_Position(row, col),
                        direction,
                        territorialPlayer.getTerritory()
                );
            }
            System.out.println(type + " placed in " + territorialPlayer.getTerritory() + "!");
        }
    }

    @Override
    public void displayBoards() {
        System.out.println("\n=== SHARED BOARD ===");
        System.out.println("Left half: Player 1 | Right half: Player 2");
        displayStrategy.displayBoard(sharedBoard, false);
    }
}
