package baseball.view;


import baseball.domain.Answer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void 사용자로부터_세_자리_정수_입력받기() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        List<Integer> inputDigits = InputView.readGuessingNumber().getDigits();
        assertThat(inputDigits).hasSize(Answer.LENGTH_OF_ANSWER);
        assertThat(inputDigits.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }
}