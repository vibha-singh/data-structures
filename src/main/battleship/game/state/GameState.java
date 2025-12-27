package main.battleship.game.state;

import lld.dec2025.battleship.game.BattleshipGame;

public interface GameState {
    void handle(BattleshipGame game);
}
