package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
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

    @Test
    @DisplayName("커스텀 패턴 확인")
    void customPattern() {
        String regex = "//(.)\\\\n(.*)";
        String target = "//;\\n1;2;3";
        Matcher matcher = Pattern.compile(regex).matcher(target);
        assertThat(matcher.find()).isTrue();
        String delimiter = matcher.group(1);
        assertThat(delimiter).isEqualTo(";");
    }
}
