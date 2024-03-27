package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    public static final int LENGTH_OF_ANSWER = 3;
    private final List<Integer> digits;

    public Answer() {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < Answer.LENGTH_OF_ANSWER; i++) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (digits.contains(newNumber)) {
                i--;
                continue;
            }
            digits.add(newNumber);
        }
        validateSize(digits);
        validateDuplicate(digits);
        this.digits = digits;
    }

    // for test
    public Answer(List<Integer> digits) {
        validateSize(digits);
        validateDuplicate(digits);
        this.digits = digits;
    }

    private void validateSize(List<Integer> digits) {
        if (digits.size() != LENGTH_OF_ANSWER)
            throw new IllegalArgumentException("정답의 자리 수가 올바르지 않습니다.");
    }

    private void validateDuplicate(List<Integer> digits) {
        Set<Integer> nonduplicateDigits = new HashSet<>(digits);
        if (nonduplicateDigits.size() != digits.size())
            throw new IllegalArgumentException("정답의 각 자리 수는 중복될 수 없습니다.");
    }

    public List<Integer> getDigits() {
        return digits;
    }
}
