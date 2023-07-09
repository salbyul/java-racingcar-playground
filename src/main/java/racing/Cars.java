package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;
    private final Winner winner;
    private final ResultView resultView;
    private final Dice dice;

    public Cars() {
        this.carList = new ArrayList<>();
        this.winner = new Winner();
        this.resultView = new ResultView();
        dice = new Dice();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void play(int count) {
        for (int i = 0; i < count; i++) {
            moveCars(dice);
            resultView.printResult(carList);
        }
        winner.setWinners(carList);
        resultView.printWinner(winner.getWinners());
    }

    private void moveCars(Dice dice) {
        for (Car car : carList) {
            DiceResult result = dice.play();
            car.move(result.getNumber());
        }
    }

    public Winner getWinner() {
        return this.winner;
    }
}
