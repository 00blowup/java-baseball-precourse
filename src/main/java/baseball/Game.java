package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Answer createAnswer() {
        return new Answer();
    }


    public Input getGuessingNumberInput() {
        return InputView.readGuessingNumber();
    }

    public void printHint(Answer answer, Input guessingInput) {
        Hint hint = new Hint(answer, guessingInput);

        int ballCount = hint.getBallCount();
        int strikeCount = hint.getStrikeCount();

        if (strikeCount == Answer.LENGTH_OF_ANSWER) {
            OutputView.printHint(Answer.LENGTH_OF_ANSWER + "스트라이크");
            OutputView.printHint("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (ballCount == 0 && strikeCount == 0) {
            OutputView.printHint("낫싱");
            return;
        }

        if (ballCount == 0) {
            OutputView.printHint(strikeCount + "스트라이크");
            return;
        }

        if (strikeCount == 0) {
            OutputView.printHint(ballCount + "볼");
            return;
        }

        OutputView.printHint(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public boolean getRestartOrQuit() {
        String command = InputView.readRestartOrQuit();
        if(command.equals("1")) return true;
        if(command.equals("2")) return false;
        throw new IllegalArgumentException("커맨드 입력값은 1 또는 2여야 합니다.");
    }
}
