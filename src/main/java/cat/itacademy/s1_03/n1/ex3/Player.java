package cat.itacademy.s1_03.n1.ex3;

public class Player {

    private final String name;
    private int score;

    public Player(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be empty");
        }
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        score++;
    }

    @Override
    public String toString() {
        return name + " - " + score + "/10";
    }
}