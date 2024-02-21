package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AnswerTest {

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