package lowLevelDesign.snakeAndLadder.model;

public class Players {
    String name;
    int position;
    boolean won;

    public Players(String name, int position) {
        this.name = name;
        this.position = 0;
        this.won = false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
