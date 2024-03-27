package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    public Answer createAnswer() {
        return new Answer();
    }

    public Input getGuessingNumberInput() {
        return InputView.readGuessingNumber();
    }

    public void printHint(Answer answer, Input guessingInput) {
        Hint hint = new Hint(answer, guessingInput);
        OutputView.printHint(hint);
    }

    public boolean isRestart() {
        return InputView.readRestartOrQuit();
    }
}
