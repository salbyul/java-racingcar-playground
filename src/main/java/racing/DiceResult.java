package racing;

public class DiceResult {
    public static final int MIN_COUNT = 4;
    private final int number;

    public DiceResult(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isPass() {
        return number >= MIN_COUNT;
    }
}
