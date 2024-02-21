package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputTest {

    @Test
    void 사용자로부터_입력값_받기() {
        String inputString = "123";
        Input input = new Input(inputString);
        List<Integer> inputDigits  = input.getDigits();
        assertThat(inputDigits).hasSize(Answer.LENGTH_OF_ANSWER);
        assertThat(inputDigits.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }

    @Test
    void 입력값이_정수가_아닌_경우_예외를_발생시킨다() {
        String nonIntegerInput = "abc";
        assertThrows(IllegalArgumentException.class, () -> new Input(nonIntegerInput));
    }

    @Test
    void 입력값의_자리_수가_너무_많은_경우_예외를_발생시킨다() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Answer.LENGTH_OF_ANSWER + 1; i++)
            sb.append(i);
        assertThrows(IllegalArgumentException.class, () -> new Input(sb.toString()));
    }

    @Test
    void 입력값의_자리_수가_너무_적은_경우_예외를_발생시킨다() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Answer.LENGTH_OF_ANSWER - 1; i++)
            sb.append(i);
        assertThrows(IllegalArgumentException.class, () -> new Input(sb.toString()));
    }

}