package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DiceTest {

    @Test
    @DisplayName("0 ~ 9 사이의 랜덤한 값 얻기")
    void getRandomNumber() {
        Dice dice = new Dice();
        DiceResult result = dice.play();
        assertThat(result.getNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤으로 생성한 값이 4 이상의 값인지")
    void isGreaterThanThree() {
        Dice dice = new Dice();
        DiceResult result = dice.play();
        assertThat(result.getNumber() >= 4).isEqualTo(result.isPass());
    }
}
