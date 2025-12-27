package main.battleship;

import lld.dec2025.battleship.game.SharedBoardGame;
import lld.dec2025.battleship.model.A_Position;
import lld.dec2025.battleship.model.Board;
import lld.dec2025.battleship.model.enums.Territory;
import lld.dec2025.battleship.player.TerritorialPlayer;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Battleship - Shared Board Edition!");
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = scanner.nextLine();

        TerritorialPlayer player1 = new TerritorialPlayer(name1, 10, Territory.PLAYER1_TERRITORY) {
            private final Set<A_Position> attackedPositions = new HashSet<>();
            private final Random random = new Random();

            @Override
            public A_Position chooseAttackPosition(Board opponentBoard) {
                A_Position position;
                do {
                    int row = random.nextInt(opponentBoard.getSize());
                    int col = random.nextInt(opponentBoard.getSize());
                    position = new A_Position(row, col);
                } while (attackedPositions.contains(position));

                attackedPositions.add(position);
                System.out.println(getName() + " attacks: Row " + position.getRow() + ", Col " + position.getCol());
                return position;
            }
        };

        TerritorialPlayer player2 = new TerritorialPlayer(name2, 10, Territory.PLAYER2_TERRITORY) {
            private final Set<A_Position> attackedPositions = new HashSet<>();
            private final Random random = new Random();

            @Override
            public A_Position chooseAttackPosition(Board opponentBoard) {
                A_Position position;
                do {
                    int row = random.nextInt(opponentBoard.getSize());
                    int col = random.nextInt(opponentBoard.getSize());
                    position = new A_Position(row, col);
                } while (attackedPositions.contains(position));

                attackedPositions.add(position);
                System.out.println(getName() + " attacks: Row " + position.getRow() + ", Col " + position.getCol());
                return position;
            }
        };

        SharedBoardGame game = new SharedBoardGame(player1, player2);
        game.start();

        scanner.close();
    }
}
