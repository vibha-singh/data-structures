package main.battleship.model;

import lld.dec2025.battleship.model.enums.ShipType;

public interface IShip {
    ShipType getType();
    boolean isSunk();
    void hit();
    int getSize();
    int getHits();
}
