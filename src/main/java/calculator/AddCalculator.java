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
        if (input.contains(",") || input.contains(":")) {
            Character delimiter = getDelimiter(input);
            return input.split(String.valueOf(delimiter));
        }
        Character customDelimiter = getCustomDelimiter(input);
        String substring = input.substring(5);
        return substring.split(String.valueOf(customDelimiter));
    }
}
