package main.battleship.player;

import lld.dec2025.battleship.model.enums.Territory;

public abstract class TerritorialPlayer extends Player {
    protected final Territory territory;

    public TerritorialPlayer(String name, int boardSize, Territory territory) {
        super(name, boardSize);
        this.territory = territory;
    }

    public Territory getTerritory() {
        return territory;
    }
}
