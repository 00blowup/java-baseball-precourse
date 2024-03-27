package baseball;

import baseball.domain.Answer;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @Test
    void 생성된_정답이_세_자리_정수이다() {
        Game game = new Game();
        List<Integer> generatedAnswer = game.createAnswer().getDigits();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(generatedAnswer).hasSize(Answer.LENGTH_OF_ANSWER);
        softly.assertThat(generatedAnswer.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
        softly.assertAll();
    }

    @Test
    void 사용자로부터_받은_입력값이_세_자리_정수이다() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        Game game = new Game();
        List<Integer> inputDigits = game.getGuessingNumberInput().getDigits();
        assertThat(inputDigits).hasSize(Answer.LENGTH_OF_ANSWER);
        assertThat(inputDigits.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }
}