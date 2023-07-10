package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ResultViewTest {

    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("모두 전진하지 못했을 경우 결과 출력")
    void printResultAllStop() {
        Cars cars = new Cars(Arrays.asList(new Car("강감찬"), new Car("이순신"), new Car("율곡 이이")));
        ResultView resultView = new ResultView();
        resultView.printResult(cars.getCars());
        assertThat(outputStream.toString()).isEqualTo("강감찬 : \n이순신 : \n율곡 이이 : \n");
    }

    @Test
    @DisplayName("모두 전진했을 경우 결과 출력")
    void printResultAllMove() {
        Cars cars = new Cars(Arrays.asList(new Car("강감찬", 1), new Car("이순신", 1), new Car("율곡 이이", 1)));
        ResultView resultView = new ResultView();
        resultView.printResult(cars.getCars());
        assertThat(outputStream.toString()).isEqualTo("강감찬 : -\n이순신 : -\n율곡 이이 : -\n");
    }

    @Test
    @DisplayName("우승자 1명일 시 출력")
    void printWinner() {
        Cars cars = new Cars(Arrays.asList(new Car("강감찬", 1), new Car("이순신", 1), new Car("율곡 이이", 2)));
        Game game = new Game(cars);
        ResultView resultView = new ResultView();
        resultView.printWinners(game.getWinners());
        assertThat(outputStream.toString()).isEqualTo("율곡 이이가 최종 우승했습니다.\n");
    }

    @Test
    @DisplayName("우승자 2명일 시 출력")
    void printWinners() {
        Cars cars = new Cars(Arrays.asList(new Car("강감찬", 2), new Car("이순신", 3), new Car("율곡 이이", 3)));
        Game game = new Game(cars);
        ResultView resultView = new ResultView();
        resultView.printWinners(game.getWinners());
        assertThat(outputStream.toString()).isEqualTo("이순신, 율곡 이이가 최종 우승했습니다.\n");
    }
}
