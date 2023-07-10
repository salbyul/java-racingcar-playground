package racing;

public class Car {

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        position = new Position(0);
    }

    public void move(final int number) {
        if (isGreaterThanThree(number)) {
            this.position.increase();
        }
    }

    private boolean isGreaterThanThree(int number) {
        return number > 3;
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
