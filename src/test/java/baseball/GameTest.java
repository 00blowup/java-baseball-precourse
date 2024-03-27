package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;
import camp.nextstep.edu.missionutils.Randoms;
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

    public static List<String> generateRandomInputString() {

        List<String> inputStrings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inputStrings.add(Integer.toString(Randoms.pickNumberInRange(100, 999)));
        }

        return inputStrings;
    }

    public static Stream<Arguments> provideCounts() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 1),
                Arguments.of(0, Answer.LENGTH_OF_ANSWER),
                Arguments.of(1, 0),
                Arguments.of(Answer.LENGTH_OF_ANSWER, 0),
                Arguments.of(1, 1)
        );
    }

    @Test
    void 생성된_정답이_세_자리_정수이다() {
        Game game = new Game();
        List<Integer> generatedAnswer = game.createAnswer().getDigits();
        assertThat(generatedAnswer).hasSize(Answer.LENGTH_OF_ANSWER);
        assertThat(generatedAnswer.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }

    @Test
    void 세_자리_정수의_각_자리_수가_중복되지_않는다() {
        Game game = new Game();
        List<Integer> generatedAnswer = game.createAnswer().getDigits();
        Set<Integer> digitSet = new HashSet<>(generatedAnswer);
        assertThat(generatedAnswer).hasSameSizeAs(digitSet);
    }

    @Test
    void 사용자로부터_받은_입력값이_세_자리_정수이다() {
        System.setIn(new ByteArrayInputStream("123".getBytes()));
        Game game = new Game();
        List<Integer> inputDigits = game.getGuessingNumberInput().getDigits();
        assertThat(inputDigits).hasSize(Answer.LENGTH_OF_ANSWER);
        assertThat(inputDigits.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("generateRandomInputString")
    void 힌트_계산_테스트(String inputString) {
        Game game = new Game();

        Answer answer = game.createAnswer();
        List<Integer> answerDigits = answer.getDigits();

        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        Input guessingInput = game.getGuessingNumberInput();
        List<Integer> inputDigits = guessingInput.getDigits();

        Hint calculatedHint = game.calculateHint(answer, guessingInput);

        int correctBallCount = 0;
        int correctStrikeCount = 0;

        for (int i = 0; i < Answer.LENGTH_OF_ANSWER; i++) {
            if (answerDigits.get(i).equals(inputDigits.get(i))) {
                correctStrikeCount++;
                continue;
            }
            if (inputDigits.contains(answerDigits.get(i))) correctBallCount++;
        }

        assertThat(calculatedHint.getBallCount()).isEqualTo(correctBallCount);
        assertThat(calculatedHint.getStrikeCount()).isEqualTo(correctStrikeCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"444", "555", "666"})
    void 낫싱_테스트(String inputString) {
        Game game = new Game();

        List<Integer> answerDigits = new ArrayList<>();
        answerDigits.add(1);
        answerDigits.add(2);
        answerDigits.add(3);
        Answer answer = new Answer(answerDigits);

        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        Input guessingInput = game.getGuessingNumberInput();

        Hint calculatedHint = game.calculateHint(answer, guessingInput);

        assertThat(calculatedHint.getBallCount()).isEqualTo(0);
        assertThat(calculatedHint.getStrikeCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("provideCounts")
    void 힌트_값에_맞는_문구_출력_테스트(int ballCount, int strikeCount) {
        Game game = new Game();

        ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        Hint hint = new Hint(ballCount, strikeCount);
        game.printHint(hint);

        if (ballCount == 0 && strikeCount == 0) {
            assertThat(outputMessage.toString()).isEqualTo("낫싱\n");
            return;
        }

        if (strikeCount == Answer.LENGTH_OF_ANSWER) {
            assertThat(outputMessage.toString()).isEqualTo(Answer.LENGTH_OF_ANSWER + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            return;
        }

        if (ballCount == 0) {
            assertThat(outputMessage.toString()).isEqualTo(strikeCount + "스트라이크\n");
            return;
        }

        if (strikeCount == 0) {
            assertThat(outputMessage.toString()).isEqualTo(ballCount + "볼\n");
            return;
        }

        assertThat(outputMessage.toString()).isEqualTo(ballCount + "볼 " + strikeCount + "스트라이크\n");

    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "100", "-1", "0"})
    void 입력된_커맨드가_1_또는_2가_아닌_정수일_경우_예외를_발생시킨다(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        Game game = new Game();
        assertThrows(IllegalArgumentException.class, game::getRestartOrQuit);
    }

}