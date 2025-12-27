package main.battleship.game.state;

import lld.dec2025.battleship.game.BattleshipGame;

public class GameOverState  implements GameState {
    @Override
    public void handle(BattleshipGame game) {
        game.endGame();
    }
}
