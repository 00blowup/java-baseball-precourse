package baseball;

import baseball.domain.Answer;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void 생성된_정답이_세_자리_정수이다() {
        Game game = new Game();
        List<Integer> generatedAnswer = game.createAnswer().getDigits();
        assertThat(generatedAnswer).hasSize(3);
        assertThat(generatedAnswer.stream().allMatch(n -> n>=1 && n<=9)).isTrue();
    }

    @Test
    void 세_자리_정수의_각_자리_수가_중복되지_않는다() {
        Game game = new Game();
        List<Integer> generatedAnswer = game.createAnswer().getDigits();
        Set<Integer> digitSet = new HashSet<>(generatedAnswer);
        assertThat(generatedAnswer).hasSameSizeAs(digitSet);
    }

}