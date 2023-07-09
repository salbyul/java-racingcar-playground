package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {

    @ParameterizedTest
    @DisplayName("자동차 이름받고 쉼표로 구분하기")
    @ValueSource(strings = {"Bruno Mars,Justin Bieber,DJ khaled"})
    void getCarName(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView(new Scanner(System.in));
        String[] names = inputView.getCarNames();
        assertThat(names).containsExactly("Bruno Mars", "Justin Bieber", "DJ khaled");
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수 입력받기")
    @ValueSource(ints = {1, 10, 30})
    void getNumber(int number) {
        System.setIn(generateInputStream(number));
        InputView inputView = new InputView(new Scanner(System.in));
        int input = inputView.getNumber();
        assertThat(input).isEqualTo(number);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 횟수 입력받을 때")
    @CsvSource(value = {"a", "-"})
    void validateNotNumber(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView(new Scanner(System.in));
        RuntimeException exception = assertThrows(RuntimeException.class, inputView::getNumber);
        assertThat(exception.getMessage()).isEqualTo("숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("0 이하의 횟수 입력받기")
    @ValueSource(ints = {0, -1, -100})
    void validateNotPositiveNumber(int input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView(new Scanner(System.in));
        RuntimeException exception = assertThrows(RuntimeException.class, inputView::getNumber);
        assertThat(exception.getMessage()).isEqualTo("1 이상의 숫자만 입력할 수 있습니다.");
    }

    static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }

    static InputStream generateInputStream(int input) {
        String parsedString = String.valueOf(input);
        return new ByteArrayInputStream(parsedString.getBytes(StandardCharsets.UTF_8));
    }
}
