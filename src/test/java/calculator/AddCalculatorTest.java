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
import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @DisplayName("구분자 확인")
    @CsvSource(value = {"1,2,3=,", "10:20:30=:"}, delimiter = '=')
    void getDelimiter(String input, Character expectedDelimiter) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        Character delimiter = calculator.getDelimiter(input);
        assertThat(delimiter).isEqualTo(expectedDelimiter);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자 확인")
    @CsvSource(value = {"//;\\n1;2;3=;", "//?\\n10?20?30=?"}, delimiter = '=')
    void getCustomDelimiter(String input, Character expectedDelimiter) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        Character delimiter = calculator.getCustomDelimiter(input);
        assertThat(delimiter).isEqualTo(expectedDelimiter);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자 잘못된 문자열 사용")
    @CsvSource(value = {"1;2;3=;", "/q\\n10q20q30q"}, delimiter = '=')
    void invalidCustomDelimiter(String input) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.getCustomDelimiter(input);
        });
        assertThat(exception.getMessage()).isEqualTo("잘못된 문자열입니다.");
    }

    @ParameterizedTest
    @DisplayName("구분자를 기준으로 숫자 구분")
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    void separateNumberByDefaultDelimiter(String input) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        String[] split = calculator.getSplit(input);
        assertThat(split).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 기준으로 숫자 구분")
    @ValueSource(strings = {"//;\\n1;2;3", "//=\\n1=2=3"})
    void separateNumberByCustomDelimiter(String input) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        String[] split = calculator.getSplit(input);
        assertThat(split).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @DisplayName("구분된 숫자들 더하기")
    @CsvSource(value = {"//;\\n1;2;3=6", "1,2,3=6", "10:20:30=60", "//!\\n3!6!9=18"}, delimiter = '=')
    void addSplit(String input, int expectedResult) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        int result = calculator.add(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 값 입력 시 예외 발생")
    @ValueSource(strings = {"a,s,d,f", "q:w:e:r", "//(\\nq(w(e(", "//&\\n가&나&다"})
    void notNumberInput(String input) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculator.validateInput(input);
        });
        assertThat(exception.getMessage()).isEqualTo("양수인 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("음수 입력 시 예외 발생")
    @ValueSource(strings = {"-1,-2,-3", "-10:10:365", "//;\\n9;-3;10"})
    void isPositiveNumber(String input) {
        AddCalculator calculator = new AddCalculator(new Scanner(System.in));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculator.validateInput(input);
        });
        assertThat(exception.getMessage()).isEqualTo("양수인 숫자만 입력이 가능합니다.");
    }

    public static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }
}
