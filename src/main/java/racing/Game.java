package racing;

import racing.car.Car;

import java.util.List;

public class Game {

    private final Cars cars;
    private final Winner winners;

    public Game(final Cars cars) {
        this.cars = cars;
        winners = new Winner();
    }

    public List<Car> getWinners() {
        organizeWinners();
        return winners.getWinners();
    }

    private void organizeWinners() {
        int maxPosition = findMaxPosition();
        for (Car car : cars.getCars()) {
            if (isSamePosition(maxPosition, car)) {
                winners.addWinner(car);
            }
        }
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private boolean isSamePosition(final int maxPosition, final Car car) {
        return car.getPosition() == maxPosition;
    }
}
