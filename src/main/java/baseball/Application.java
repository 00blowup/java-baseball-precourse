package baseball;

import baseball.domain.Answer;
import baseball.domain.Hint;
import baseball.domain.Input;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        while(true) {
            boolean ifRestart = play();
            if(!ifRestart) break;
        }
    }

    public static boolean play() {
        Game game = new Game();

        Answer answer = game.createAnswer();

        while(true) {
            Input input = game.getGuessingNumberInput();
            Hint hint = game.calculateHint(answer, input);
            game.printHint(hint);

            if(hint.getStrikeCount()==Answer.LENGTH_OF_ANSWER)
                break;
        }

        return game.getRestartOrQuit();
    }
}
