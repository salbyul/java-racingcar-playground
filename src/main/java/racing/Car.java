package racing;

import java.util.Objects;

public class Car {

    public static final int MIN_NAME_LENGTH = 4;
    public static final int MIN_COUNT = 4;
    public static final String INVALID_NAME_LENGTH_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
        this.name = name;
        this.position = 0;
    }

    public void move(int condition) {
        if (condition >= MIN_COUNT) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
