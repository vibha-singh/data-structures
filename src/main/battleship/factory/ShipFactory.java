package main.battleship.factory;

import lld.dec2025.battleship.model.ConcreteShip;
import lld.dec2025.battleship.model.IShip;
import lld.dec2025.battleship.model.enums.ShipType;

public class ShipFactory {
    public IShip createShip(ShipType type) {
        return new ConcreteShip(type);
    }
}
