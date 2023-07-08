package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class PatternTest {

    @Test
    @DisplayName("패턴 테스트")
    void regex() {
        String regex = "\\d*";
        String target = "1284678792";
        boolean result = Pattern.matches(regex, target);
        assertThat(result).isTrue();
    }
}
