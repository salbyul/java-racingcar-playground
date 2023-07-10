package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @BeforeEach
    void setUp() {
        System.setIn(null);
    }

    @ParameterizedTest
    @DisplayName("자동차의 이름을 입력받기")
    @ValueSource(strings = "pobi,crong,honux\n")
    void getCarNames(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 5자 초과할 경우 예외 발생")
    @ValueSource(strings = {"crongA\n", "superMan,batMan\n"})
    void carNameGreaterThanFive(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 입력되지 않으면 예외 발생")
    void noCarName() {
        System.setIn(generateInputStream("\n"));
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::getCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 1개 이상 입력되어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수 입력받기")
    @ValueSource(strings = {"1", "10", "100"})
    void getNumberOfAttempts(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView();
        int numberOfAttempts = inputView.getNumberOfAttempts();
        assertThat(numberOfAttempts).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값 입력 시 예외 발생")
    @ValueSource(strings = {"strong", "+_+", ">.<", "/'].;["})
    void notNumber(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::getNumberOfAttempts)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("양수가 아닌 숫자 입력시 예외 발생")
    @ValueSource(strings = {"-1", "0"})
    void notPositiveNumber(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::getNumberOfAttempts)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 숫자만 입력이 가능합니다.");
    }

    static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
