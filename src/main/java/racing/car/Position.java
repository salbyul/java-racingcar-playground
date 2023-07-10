package racing.car;

public class Position {

    private Integer position;

    public Position(final Integer position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
