package main.battleship.display;

import lld.dec2025.battleship.model.Board;

public interface DisplayStrategy {
    void displayBoard(Board board, boolean hideShips);
}
