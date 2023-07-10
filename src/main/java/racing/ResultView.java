package racing;

import java.util.List;

public class ResultView {

    public void printResult(final List<Car> cars) {
        for (Car car : cars) {
            printResult(car);
        }
    }

    private void printResult(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }

    public void printWinners(final List<Car> winners) {
        StringBuilder stringBuilder = makeWinnerString(winners);
        System.out.println(stringBuilder);
    }

    private StringBuilder makeWinnerString(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winners.get(0).getName());
        for (int i = 1; i < winners.size(); i++) {
            stringBuilder.append(", ").append(winners.get(i).getName());
        }
        stringBuilder.append("가 최종 우승했습니다.");
        return stringBuilder;
    }
}
