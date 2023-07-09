package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final Dice dice;

    public Cars() {
        this.cars = new ArrayList<>();
        dice = new Dice();
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
