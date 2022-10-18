package lowLevelDesign.snakeAndLadder.model;


import java.util.List;
import java.util.Queue;

public class Game {
     private int noOfSnakes;
     private int noOfLadders;
     
     private Queue<Players> players;
     private List<Snake> snakes;
     private List<Ladder> ladders;

     private Board board;
     private Dice dice;

    public Game() {
    }
}
