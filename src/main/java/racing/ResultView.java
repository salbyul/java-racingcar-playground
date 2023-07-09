package racing;

import java.util.List;

public class ResultView {


    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printDash(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printDash(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0).getName());
        System.out.print("[");
        for (int i = 1; i < winners.size(); i++) {
            sb.append(", ").append(winners.get(i).getName());
        }
        sb.append("가 최종 우승했습니다.]");
        System.out.println(sb);
    }
}
