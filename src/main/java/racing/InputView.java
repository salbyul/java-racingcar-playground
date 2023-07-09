package racing;

import java.util.Scanner;

public class InputView {

    private static final int MIN_COUNT = 1;
    public static final String DELIMITER = ",";
    public static final String NOT_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
    public static final String NOT_POSITIVE_NUMBER_MESSAGE = "1 이상의 숫자만 입력할 수 있습니다.";
    public static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String GET_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCarNames() {
        System.out.println(GET_CAR_NAME_MESSAGE);
        String input = scanner.nextLine();
        return input.split(DELIMITER);
    }

    public int getNumber() {
        System.out.println(GET_NUMBER_MESSAGE);
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
