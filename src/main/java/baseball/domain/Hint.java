package baseball.domain;

import java.util.List;

public class Hint {

    private final int ballCount;
    private final int strikeCount;

    public Hint(Answer answer, Input guessingInput) {
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

        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
