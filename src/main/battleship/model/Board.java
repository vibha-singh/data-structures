package main.battleship.model;

import lld.dec2025.battleship.model.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;
    private final B_Cell[][] grid;
    private final List<IShip> ships;

    public Board(int size) {
        this.size = size;
        this.grid = new B_Cell[size][size];
        this.ships = new ArrayList<>();
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new B_Cell();
            }
        }
    }

    public boolean placeShip(IShip ship, A_Position start, Direction direction) {
        if (!canPlaceShip(ship, start, direction)) {
            return false;
        }

        List<A_Position> positions = getShipPositions(start, ship.getSize(), direction);
        for (A_Position pos : positions) {
            grid[pos.getRow()][pos.getCol()].placeShip(ship);
        }

        ships.add(ship);
        return true;
    }

    private boolean canPlaceShip(IShip ship, A_Position start, Direction direction) {
        List<A_Position> positions = getShipPositions(start, ship.getSize(), direction);

        for (A_Position pos : positions) {
            if (!isValidPosition(pos) || grid[pos.getRow()][pos.getCol()].hasShip()) {
                return false;
            }
        }
        return true;
    }

    private List<A_Position> getShipPositions(A_Position start, int size, Direction direction) {
        List<A_Position> positions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int row = direction == Direction.HORIZONTAL ? start.getRow() : start.getRow() + i;
            int col = direction == Direction.HORIZONTAL ? start.getCol() + i : start.getCol();
            positions.add(new A_Position(row, col));
        }
        return positions;
    }

    private boolean isValidPosition(A_Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < size &&
                pos.getCol() >= 0 && pos.getCol() < size;
    }

    public boolean attack(A_Position pos) {
        if (!isValidPosition(pos)) {
            return false;
        }
        return grid[pos.getRow()][pos.getCol()].attack();
    }

    public boolean allShipsSunk() {
        return ships.stream().allMatch(IShip::isSunk);
    }

    public B_Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }

    public List<IShip> getShips() {
        return new ArrayList<>(ships);
    }
}
