package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("랜덤한 값이 4 이상 나올 시 전진하기")
    void moveIfGreaterThanThree() {
        Car car = new Car("happy");
        car.move(4);
        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤한 값이 4 미만 나올 시 전진하지 않기")
    @ValueSource(ints = {1, 2, 3})
    void CantMove(int randomNumber) {
        Car happy = new Car("happy");
        happy.move(randomNumber);
        int position = happy.getPosition();
        assertThat(position).isEqualTo(0);
    }
}
