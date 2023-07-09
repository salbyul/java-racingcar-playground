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
}
