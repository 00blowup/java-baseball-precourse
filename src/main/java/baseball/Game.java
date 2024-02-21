package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Answer createAnswer() {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < Answer.LENGTH_OF_ANSWER; i++) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (digits.contains(newNumber)) {
                i--;
                continue;
            }
            digits.add(newNumber);
        }

        return new Answer(digits);
    }


    public Input getGuessingNumberInput() {
        return InputView.readGuessingNumber();
    }

    public Hint calculateHint(Answer answer, Input guessingInput) {
        List<Integer> answerDigits = answer.getDigits();
        List<Integer> inputDigits = guessingInput.getDigits();

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < Answer.LENGTH_OF_ANSWER; i++) {
            if (answerDigits.get(i).equals(inputDigits.get(i))) {
                strikeCount++;
                continue;
            }
            if (inputDigits.contains(answerDigits.get(i))) ballCount++;
        }

        return new Hint(ballCount, strikeCount);
    }

}
