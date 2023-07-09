package racing;

import java.util.Scanner;

public class InputView {

    private static final int MIN_COUNT = 1;
    public static final String DELIMITER = ",";
    public static final String NOT_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
    public static final String NOT_POSITIVE_NUMBER_MESSAGE = "1 이상의 숫자만 입력할 수 있습니다.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCarNames() {
        String input = scanner.nextLine();
        return input.split(DELIMITER);
    }

    public int getNumber() {
        String number = scanner.nextLine();
        try {
            int parsedInteger = Integer.parseInt(number);
            validateNumber(parsedInteger);
            return parsedInteger;
        } catch (NumberFormatException e) {
            throw new RuntimeException(NOT_NUMBER_MESSAGE);
        }
    }

    private void validateNumber(int parsedInteger) {
        if (parsedInteger < MIN_COUNT) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_MESSAGE);
        }
    }
}
