package racing;

public class Car {

    public static final int MIN_NAME_LENGTH = 4;
    public static final int MIN_COUNT = 4;
    private final String name;
    private Integer position;

    public Car(String name) {
        if (name.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
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
}
