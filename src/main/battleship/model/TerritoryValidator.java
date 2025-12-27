package main.battleship.model;

import lld.dec2025.battleship.model.enums.Direction;
import lld.dec2025.battleship.model.enums.Territory;

public class TerritoryValidator {
    private final int boardSize;
    private final int midpoint;

    public TerritoryValidator(int boardSize) {
        this.boardSize = boardSize;
        this.midpoint = boardSize / 2;
    }

    public Territory getTerritory(A_Position pos) {
        // Left half = Player 1, Right half = Player 2
        return pos.getCol() < midpoint ? Territory.PLAYER1_TERRITORY : Territory.PLAYER2_TERRITORY;
    }

    public boolean isInTerritory(A_Position pos, Territory territory) {
        return getTerritory(pos) == territory;
    }

    public boolean canPlaceInTerritory(A_Position pos, int shipSize, Direction direction, Territory territory) {
        // Check if entire ship fits within territory
        for (int i = 0; i < shipSize; i++) {
            int row = direction == Direction.HORIZONTAL ? pos.getRow() : pos.getRow() + i;
            int col = direction == Direction.HORIZONTAL ? pos.getCol() + i : pos.getCol();
            A_Position checkPos = new A_Position(row, col);

            if (!isInTerritory(checkPos, territory)) {
                return false;
            }
        }
        return true;
    }
}
