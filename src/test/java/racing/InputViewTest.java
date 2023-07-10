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

    static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
