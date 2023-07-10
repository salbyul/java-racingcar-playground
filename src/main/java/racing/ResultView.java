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
}
