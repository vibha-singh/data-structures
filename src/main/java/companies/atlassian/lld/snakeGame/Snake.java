package companies.atlassian.snakeGame;

import java.util.Deque;
import java.util.LinkedList;

public class Snake {
    Deque<Cell> snake = new LinkedList<>();
    private Cell head;

    public Snake(Cell initPos) {
        head = initPos;
        snake.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }

    public Deque<Cell> getSnake() {
        return snake;
    }

    public void setSnake(LinkedList<Cell> snake) {
        this.snake = snake;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }

    public void move(Cell nextCell) {
        System.out.println("Snake moving to" + nextCell.getRow() +" "+nextCell.getCol());
        Cell tail = snake.removeLast();
        tail.setCellType(CellType.EMPTY);

        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snake.add(head);
    }

    public boolean checkCrash(Cell nextCell) {
        System.out.println("Checking for crash");
        for(Cell cell : snake) {
            if(cell == nextCell){
                System.out.println("Snake Crashed!!");
                return true;
            }
        }
        return false;
    }
}
