package calculator;

import java.util.Scanner;

public class AddCalculator {

    private final Scanner scanner;

    public AddCalculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
