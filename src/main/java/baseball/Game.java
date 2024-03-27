package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private Answer answer;

    public Game() {
    }

    public void play() {
        answer = createAnswer();
        while(true) {
            Input input = getGuessingNumberInput();
            Hint hint = printHint(answer, input);
            if(hint.getStrikeCount() == Answer.LENGTH_OF_ANSWER) break;
        }
        if(isRestart()) play();
    }

    public Answer createAnswer() {
        return new Answer();
    }

    public Input getGuessingNumberInput() {
        return InputView.readGuessingNumber();
    }

    public Hint printHint(Answer answer, Input guessingInput) {
        Hint hint = new Hint(answer, guessingInput);
        OutputView.printHint(hint);
        return hint;
    }

    public boolean isRestart() {
        return InputView.readRestartOrQuit();
    }
}
