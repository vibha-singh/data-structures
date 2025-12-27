package main.battleship.model;

import lld.dec2025.battleship.model.enums.CellState;

public class B_Cell {
    private CellState state;
    private IShip ship;

    public B_Cell() {
        this.state = CellState.EMPTY;
        this.ship = null;
    }

    public CellState getState() {
        return state;
    }

    public void placeShip(IShip ship) {
        this.ship = ship;
        this.state = CellState.SHIP;
    }

    public boolean hasShip() {
        return ship != null;
    }

    public IShip getShip() {
        return ship;
    }

    public boolean attack() {
        if (state == CellState.HIT || state == CellState.MISS) {
            return false; // Already attacked
        }

        if (hasShip()) {
            state = CellState.HIT;
            ship.hit();
            return true;
        } else {
            state = CellState.MISS;
            return false;
        }
    }
}
