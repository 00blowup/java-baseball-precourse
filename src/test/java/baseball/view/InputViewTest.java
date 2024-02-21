package baseball.view;


import baseball.domain.Answer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @Test
    void 사용자로부터_세_자리_정수_입력받기() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        List<Integer> inputDigits = InputView.readGuessingNumber().getDigits();
        assertThat(inputDigits).hasSize(Answer.LENGTH_OF_ANSWER);
        assertThat(inputDigits.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
        System.setIn(System.in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1", "abc", "0fjd8", "가나다"})
    void 입력된_커맨드가_정수가_아닌_경우_예외를_발생시킨다(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        assertThrows(IllegalArgumentException.class, InputView::readRestartOrQuit);
        System.setIn(System.in);
    }
}