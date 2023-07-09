package racing;

import java.util.Random;

public class Dice {

    public DiceResult play() {
        Random random = new Random();
        int number = random.nextInt(8) + 1;
        return new DiceResult(number);
    }
}
