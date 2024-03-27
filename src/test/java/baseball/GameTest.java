package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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