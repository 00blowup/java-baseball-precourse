package baseball.domain;

import baseball.Game;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnswerTest {

    @Test
    void 랜덤_정답_생성_테스트() {
        List<Integer> generatedAnswer = new Answer().getDigits();
        assertThat(generatedAnswer.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }

    @Test
    void 생성된_정답의_각_자리_수가_중복되지_않는다() {
        Game game = new Game();
        List<Integer> generatedAnswer = game.createAnswer().getDigits();
        Set<Integer> digitSet = new HashSet<>(generatedAnswer);
        assertThat(generatedAnswer).hasSameSizeAs(digitSet);
    }

    @Test
    void 정답의_자리_수가_너무_많은_경우_예외를_발생시킨다() {
        List<Integer> tooManyDigits = new ArrayList<>();
        for (int i = 1; i <= Answer.LENGTH_OF_ANSWER + 1; i++) tooManyDigits.add(i);
        assertThrows(IllegalArgumentException.class, () ->
                new Answer(tooManyDigits));
    }

    @Test
    void 정답의_자리_수가_너무_적은_경우_예외를_발생시킨다() {
        List<Integer> tooFewDigits = new ArrayList<>();
        for (int i = 1; i <= Answer.LENGTH_OF_ANSWER - 1; i++) tooFewDigits.add(i);
        assertThrows(IllegalArgumentException.class, () ->
                new Answer(tooFewDigits));
    }

    @Test
    void 정답의_각_자리_수끼리_중복될_경우_예외를_발생시킨다() {
        List<Integer> duplicateDigits = new ArrayList<>();
        for (int i = 0; i <= Answer.LENGTH_OF_ANSWER; i++) duplicateDigits.add(1);
        assertThrows(IllegalArgumentException.class, () ->
                new Answer(duplicateDigits));
    }

}