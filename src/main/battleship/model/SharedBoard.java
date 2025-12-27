package main.battleship.model;

import lld.dec2025.battleship.model.enums.Direction;
import lld.dec2025.battleship.model.enums.Territory;

public class SharedBoard extends Board {
    private final TerritoryValidator territoryValidator;

    public SharedBoard(int size) {
        super(size);
        this.territoryValidator = new TerritoryValidator(size);
    }

    public boolean placeShipInTerritory(IShip ship, A_Position start, Direction direction, Territory territory) {
        // Validate ship is entirely within player's territory
        if (!territoryValidator.canPlaceInTerritory(start, ship.getSize(), direction, territory)) {
            return false;
        }

        return super.placeShip(ship, start, direction);
    }

    public Territory getTerritory(A_Position pos) {
        return territoryValidator.getTerritory(pos);
    }
}
