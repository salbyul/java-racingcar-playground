package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {

    private final Scanner scanner;

    public AddCalculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public Boolean checkOnlyNumber(String input) {
        String regex = "\\d*";
        return Pattern.matches(regex, input);
    }

    public Character getDelimiter(String input) {
        if (input.contains(",")) {
            return ',';
        }
        return ':';
    }

    public Character getCustomDelimiter(String input) {
        String regex = "//(.)\\\\n(.*)";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            return matcher.group(1).charAt(0);
        }
        throw new IllegalArgumentException("잘못된 문자열입니다.");
    }

    public String[] getSplit(String input) {
        if (isContainsDefaultDelimiter(input)) {
            Character delimiter = getDelimiter(input);
            return input.split(String.valueOf(delimiter));
        }
        Character customDelimiter = getCustomDelimiter(input);
        String substring = input.substring(5);
        return substring.split("\\" + customDelimiter);
    }

    private boolean isContainsDefaultDelimiter(String input) {
        return input.contains(",") || input.contains(":");
    }

    public int add(String input) {
        String[] split = getSplit(input);
        int result = 0;
        for (String s : split) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    public void validateInput(String input) {
        String[] split = getSplit(input);
        try {
            int[] parsedInts = parseInt(split);
            validateIsPositiveNumberArray(parsedInts);
        } catch (NumberFormatException e) {
            throw new RuntimeException("양수인 숫자만 입력이 가능합니다.");
        }
    }

    private void validateIsPositiveNumberArray(int[] parsedInts) {
        for (int number : parsedInts) {
            validateIsPositiveNumber(number);
        }
    }

    private void validateIsPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("양수인 숫자만 입력이 가능합니다.");
        }
    }

    private int[] parseInt(String[] split) {
        int[] arr = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}
