package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class AddCalculatorTest {

    /**
     * 기능 구현 목록
     * 1. 유저의 입력 받기
     * 2. 구분자 또는 커스텀 구분자 확인
     * 2. 구분자를 기준으로 숫자 구분
     * 4. 구분된 숫자들을 더하기
     * 5. 유효성 검사 (숫자 이외의 값 또는 음수를 입력할 경우 RuntimeException 발생)
     * 6. 숫자 하나를 입력했는지 확인
     */

    @ParameterizedTest
    @DisplayName("유저의 입력 받기")
    @ValueSource(strings = {"1,2,3", "10:20:30"})
    void getInput(String input) {
        System.setIn(generateInputStream(input));
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        String gotInput = calculator.getInput();
        assertThat(gotInput).isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 입력했는지 확인")
    @CsvSource(value = {"1234:true", "a123:false", "1a23:false", "123a:false"}, delimiter = ':')
    void checkOnlyNumber(String input, Boolean expectedResult) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        Boolean result = calculator.checkOnlyNumber(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    public static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
