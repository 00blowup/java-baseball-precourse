package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HintTest {

    @Test
    void 정상적으로_힌트_생성하기() {
        int ballCount = 1;
        int strikeCount = Answer.LENGTH_OF_ANSWER - ballCount;

        Hint generatedHint = new Hint(ballCount, strikeCount);

        assertThat(generatedHint.getBallCount()).isEqualTo(ballCount);
        assertThat(generatedHint.getStrikeCount()).isEqualTo(strikeCount);
    }

    @Test
    void 볼_개수가_음수인_경우_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hint(-1, 0));
    }

    @Test
    void 스트라이크_개수가_음수인_경우_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hint(0, -1));
    }

    @Test
    void 볼과_스트라이크_개수의_합이_정답_자리_수를_초과하는_경우_예외를_발생시킨다() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hint(Answer.LENGTH_OF_ANSWER, 1));
    }
}