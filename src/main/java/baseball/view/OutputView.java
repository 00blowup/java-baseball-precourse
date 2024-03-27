package baseball.view;

import baseball.domain.Answer;
import baseball.domain.Hint;

public class OutputView {
    private OutputView() {
    }

    public static void printHint(Hint hint) {
        int ballCount = hint.getBallCount();
        int strikeCount = hint.getStrikeCount();

        if (strikeCount == Answer.LENGTH_OF_ANSWER) {
            System.out.println(Answer.LENGTH_OF_ANSWER + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return;
        }
        if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        }
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}
