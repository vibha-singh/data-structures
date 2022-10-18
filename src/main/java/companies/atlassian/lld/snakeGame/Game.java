package companies.atlassian.snakeGame;

public class Game {
    public static final int DIREC_UP = 2, DIREC_DOWN = -2, DIREC_LEFT = -1, DIREC_RIGHT = 1, DIREC_NONE = 0;
    private Snake snake;
    private Board board;

    private int direc;
    private boolean gameOver;

    Game(Snake snake, Board board){
        this.snake = snake;
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDirec() {
        return direc;
    }

    public void setDirec(int direc) {
        this.direc = direc;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }


    public void update() {
        System.out.println("Going to update the game!!!");
        if(!gameOver) {
            if(direc != DIREC_NONE) {
                Cell nextCell = getNextCell(snake.getHead());
                if(snake.checkCrash(nextCell)) {
                    setDirec(DIREC_NONE);
                    gameOver = true;
                } else {
                    snake.move(nextCell);
                    if(nextCell.getCellType() == CellType.FOOD) {
                        snake.setHead(nextCell);
                        snake.getHead().setCellType(CellType.SNAKE_NODE);
                        snake.snake.add(snake.getHead());
                        board.generateFood();
                    }
                }
            }
        }
    }

    private Cell getNextCell (Cell currentPos) {
        System.out.println("Finding next cell!!");
        int row = currentPos.getRow();
        int col = currentPos.getCol();

        if(direc == DIREC_RIGHT ) {

            if(col == board.COL_COUNT-1) col = 0;
            else col++;

        } else if(direc == DIREC_LEFT ){

            if(col == 0) col = board.COL_COUNT-1;
            else  col--;

        } else if( direc == DIREC_UP ) {

            if( row == 0) row = board.ROW_COUNT -1;
            else row--;

        } else if( direc == DIREC_DOWN ) {

            if(row == board.ROW_COUNT-1) row = 0;
            else row++;
        }

        return board.getCells()[row][col];
    }

    public static void main(String[] args) {
        Cell initPos = new Cell(0,0);
        Snake snake = new Snake(initPos);
        Board board = new Board(10,10);

        Game game = new Game(snake, board);
        game.gameOver = false;
        game.direc = DIREC_RIGHT;


        /**
         * Add test cases for
         * 1) snake grow
         * 2) crash
         * 3) crossing boundary
         * 4) Food Eat
         */
        for(int i = 0; i< 5 ; i++) {
            if(i == 0) {
                game.board.generateFood();
            }

            int row = snake.getHead().getRow();
            int col = snake.getHead().getCol();
            snake.setHead(new Cell(row, col+1));
            snake.getHead().setCellType(CellType.SNAKE_NODE);
            snake.getSnake().add(snake.getHead());
            game.update();
            if(i == 1){
                game.direc = DIREC_DOWN;
            }

            if(i==2) {
                game.direc = DIREC_LEFT;
            }

            if(i == 3){
                game.direc = DIREC_UP;
            }

            //2) crash
            if(game.gameOver) {
                System.out.println("Game Over!!");
                break;
            }

        }

    }
}
