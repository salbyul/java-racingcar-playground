package racing;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCarNames() {
        String input = scanner.nextLine();
        return input.split(",");
    }
}
