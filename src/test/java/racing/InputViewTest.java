package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputViewTest {

    @ParameterizedTest
    @DisplayName("자동차 이름받고 쉼표로 구분하기")
    @ValueSource(strings = {"Bruno Mars,Justin Bieber,DJ khaled"})
    void getCarName(String input) {
        System.setIn(generateInputStream(input));
        InputView inputView = new InputView(new Scanner(System.in));
        String[] names = inputView.getCarNames();
        Assertions.assertThat(names).containsExactly("Bruno Mars", "Justin Bieber", "DJ khaled");
    }

    static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
