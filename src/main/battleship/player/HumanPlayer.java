package main.battleship.player;

import lld.dec2025.battleship.model.A_Position;
import lld.dec2025.battleship.model.Board;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HumanPlayer extends Player {
    private final Set<A_Position> attackedPositions;
    private final Random random;

    public HumanPlayer(String name, int boardSize) {
        super(name, boardSize);
        this.attackedPositions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public A_Position chooseAttackPosition(Board opponentBoard) {
        A_Position position;
        do {
            int row = random.nextInt(opponentBoard.getSize());
            int col = random.nextInt(opponentBoard.getSize());
            position = new A_Position(row, col);
        } while (attackedPositions.contains(position));

        attackedPositions.add(position);
        System.out.println(name + " attacks position: Row " + position.getRow() + ", Col " + position.getCol());
        return position;
    }
}
