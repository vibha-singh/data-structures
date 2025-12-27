package main.battleship.player;

import lld.dec2025.battleship.model.A_Position;
import lld.dec2025.battleship.model.Board;

public abstract class Player {
    protected final String name;
    protected final Board board;

    public Player(String name, int boardSize) {
        this.name = name;
        this.board = new Board(boardSize);
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public abstract A_Position chooseAttackPosition(Board opponentBoard);

    public boolean hasLost() {
        return board.allShipsSunk();
    }
}
