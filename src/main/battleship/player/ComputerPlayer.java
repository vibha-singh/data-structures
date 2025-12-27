package main.battleship.player;

import lld.dec2025.battleship.model.A_Position;
import lld.dec2025.battleship.model.Board;

import java.util.Random;

class ComputerPlayer extends Player {
    private final Random random;

    public ComputerPlayer(String name, int boardSize) {
        super(name, boardSize);
        this.random = new Random();
    }

    @Override
    public A_Position chooseAttackPosition(Board opponentBoard) {
        int row = random.nextInt(opponentBoard.getSize());
        int col = random.nextInt(opponentBoard.getSize());
        return new A_Position(row, col);
    }
}
