package main.battleship.display;

import lld.dec2025.battleship.model.B_Cell;
import lld.dec2025.battleship.model.Board;

public class ConsoleDisplayStrategy implements DisplayStrategy {
    @Override
    public void displayBoard(Board board, boolean hideShips) {
        System.out.print("  ");
        for (int i = 0; i < board.getSize(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < board.getSize(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board.getSize(); j++) {
                B_Cell cell = board.getCell(i, j);
                char display = getCellDisplay(cell, hideShips);
                System.out.print(display + " ");
            }
            System.out.println();
        }
    }

    private char getCellDisplay(B_Cell cell, boolean hideShips) {
        switch (cell.getState()) {
            case HIT: return 'X';
            case MISS: return 'O';
            case SHIP: return hideShips ? '~' : 'S';
            case EMPTY: return '~';
            default: return '~';
        }
    }
}