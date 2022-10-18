package lowLevelDesign.snakeAndLadder;

import java.util.Scanner;

public class SnakeLadderApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter board size: ");
        int boardSize = sc.nextInt();
        System.out.println("Enter number of players: ");
        int noOfPlayers = sc.nextInt();
        System.out.println("Enter number of snakes: ");
        int noOfSnakes = sc.nextInt();
        System.out.println("Enter number of ladders: ");
        int noOfLadders = sc.nextInt();
    }
}
