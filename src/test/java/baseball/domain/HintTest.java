package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HintTest {
    public static List<String> generateRandomInputString() {

        List<String> inputStrings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inputStrings.add(Integer.toString(Randoms.pickNumberInRange(100, 999)));
        }

        return inputStrings;
    }

    @ParameterizedTest
    @MethodSource("generateRandomInputString")
    void 힌트_계산_테스트(String inputString) {
        Answer answer = new Answer();
        Input input = new Input(inputString);
        Hint hint = new Hint(answer, input);

        List<Integer> answerDigits = answer.getDigits();
        List<Integer> inputDigits = input.getDigits();

        int correctBallCount = 0;
        int correctStrikeCount = 0;

        for (int i = 0; i < answerDigits.size(); i++) {
            if (answerDigits.get(i).equals(inputDigits.get(i))) {
                correctStrikeCount++;
                continue;
            }
            if (inputDigits.contains(answerDigits.get(i))) correctBallCount++;
        }

        assertThat(hint.getBallCount()).isEqualTo(correctBallCount);
        assertThat(hint.getStrikeCount()).isEqualTo(correctStrikeCount);
    }
}