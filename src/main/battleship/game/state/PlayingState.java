package main.battleship.game.state;

import lld.dec2025.battleship.game.BattleshipGame;

public class PlayingState implements GameState {
    @Override
    public void handle(BattleshipGame game) {
        game.playTurn();
    }
}
