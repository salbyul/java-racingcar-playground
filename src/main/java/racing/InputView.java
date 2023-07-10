package racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getCarNames() {
        String carNames = scanner.nextLine();
        if (carNames.equals("")) {
            throw new IllegalArgumentException("자동차의 이름이 1개 이상 입력되어야 합니다.");
        }
        String[] splitCarNames = carNames.split(",");
        for (String splitCarName : splitCarNames) {
            if (splitCarName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
            }
        }
        return Arrays.asList(splitCarNames);
    }
}
