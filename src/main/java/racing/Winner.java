package racing;

import racing.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> winners;

    public Winner() {
        this.winners = new ArrayList<>();
    }

    public List<Car> getWinners() {
        return this.winners;
    }

    public void addWinner(final Car car) {
        winners.add(car);
    }
}
