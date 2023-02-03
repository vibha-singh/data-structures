package main.companies.atlassian.lld.snakeGame;

public class Board {
    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;

    public Board(int row, int col) {
        ROW_COUNT = row;
        COL_COUNT = col;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for(int i = 0; i<ROW_COUNT; i++) {
            for(int j = 0; j< COL_COUNT ; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood() {
        System.out.println("Going to generate food");
        int row ,col;
        while(true) {
             row = (int) (Math.random() * ROW_COUNT);
             col = (int) (Math.random() * COL_COUNT);

            if(cells[row][col].getCellType() != CellType.SNAKE_NODE)
                break;
        }

        cells[row][col].setCellType(CellType.FOOD);
        System.out.println("Food Generated at: "+row+" "+col);
    }
}
