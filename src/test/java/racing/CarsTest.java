package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCar(new Car("강감찬"));
        cars.addCar(new Car("이순신"));
        cars.addCar(new Car("세종대왕"));
        cars.addCar(new Car("율곡이이"));
    }

//    TODO: 랜덤한 결과값을 어떻게 예측해서 테스트를 해야할 지 모르겠다.
    @Test
    @DisplayName("우승 자동차 확인")
    void checkWinner() {
    }
}
