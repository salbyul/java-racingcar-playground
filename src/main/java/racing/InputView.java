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
        validateNoName(carNames);

        String[] splitCarNames = carNames.split(",");
        for (String splitCarName : splitCarNames) {
            validateCarNameLength(splitCarName);
        }
        return Arrays.asList(splitCarNames);
    }

    private void validateNoName(String carNames) {
        if (carNames.equals("")) {
            throw new IllegalArgumentException("자동차의 이름이 1개 이상 입력되어야 합니다.");
        }
    }

    private void validateCarNameLength(String splitCarName) {
        if (splitCarName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getNumberOfAttempts() {
        String numberOfAttempts = scanner.nextLine();
        int parsedNumberOfAttempts = parseInt(numberOfAttempts);
        validateNumberOfAttempts(parsedNumberOfAttempts);
        return parsedNumberOfAttempts;
    }

    private void validateNumberOfAttempts(int parsedNumberOfAttempts) {
        if (parsedNumberOfAttempts < 1) {
            throw new IllegalArgumentException("1 이상의 숫자만 입력이 가능합니다.");
        }
    }

    private int parseInt(String numberOfAttempts) {
        try {
            return Integer.parseInt(numberOfAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
