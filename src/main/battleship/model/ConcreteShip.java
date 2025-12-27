package main.battleship.model;

import lld.dec2025.battleship.model.enums.ShipType;

public class ConcreteShip implements IShip {
    private final ShipType type;
    private int hits;

    public ConcreteShip(ShipType type) {
        this.type = type;
        this.hits = 0;
    }

    @Override
    public ShipType getType() {
        return type;
    }

    @Override
    public boolean isSunk() {
        return hits >= type.getSize();
    }

    @Override
    public void hit() {
        if (!isSunk()) {
            hits++;
        }
    }

    @Override
    public int getSize() {
        return type.getSize();
    }

    @Override
    public int getHits() {
        return hits;
    }
}