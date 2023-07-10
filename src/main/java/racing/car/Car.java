package racing.car;

public class Car {

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(final int number) {
        if (isGreaterThanThree(number)) {
            this.position.increase();
        }
    }

    private boolean isGreaterThanThree(final int number) {
        return number > 3;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }
}
