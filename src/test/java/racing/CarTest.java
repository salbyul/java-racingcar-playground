package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("4이상일 시 전진하기")
    void move() {
        Car car = new Car("이름");
        Car car2 = new Car("이름2");
        car.move(4);
        car2.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 5자 초과 금지")
    @CsvSource(value = {"다섯글자넘어", "요것도 다섯글자넘구", "딱다섯글자"})
    void validateCarName(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}
