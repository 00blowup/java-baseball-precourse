package baseball.domain;

public class Hint {

    private final int ballCount;
    private final int strikeCount;

    public Hint(int ballCount, int strikeCount) {
        validateValueRange(ballCount, strikeCount);
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    private void validateValueRange(int ballCount, int strikeCount) {
        if (ballCount < 0 ||
                strikeCount < 0 ||
                ballCount + strikeCount > Answer.LENGTH_OF_ANSWER)
            throw new IllegalArgumentException("볼 또는 스트라이크 개수의 값이 너무 작거나 큽니다.");
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
