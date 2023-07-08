package calculator;

import java.util.Scanner;
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
}
