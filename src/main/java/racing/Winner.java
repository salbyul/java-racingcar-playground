package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Winner {

    private final List<Car> winners;

    public Winner() {
        this.winners = new ArrayList<>();
    }

    public void setWinners(List<Car> cars) {
        Queue<Car> sortedCars = new PriorityQueue<>((o1, o2) -> o2.getPosition() - o1.getPosition());
        sortedCars.addAll(cars);
        Car firstWinner = sortedCars.poll();
        int max = firstWinner.getPosition();
        winners.add(firstWinner);

        for (int i = 0; i < sortedCars.size(); i++) {
            Car poll = sortedCars.poll();
            addWinnerAfterValidate(max, poll);
        }
    }

    private void addWinnerAfterValidate(int max, Car car) {
        int position = car.getPosition();
        if (max == position) {
            winners.add(car);
        }
    }

    public List<Car> getWinners() {
        return this.winners;
    }
}
