package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final List<Integer> digits;

    public Input(String inputString) {
        validateInteger(inputString);
        validateLength(inputString);
        digits = new ArrayList<>();
        for (char c : inputString.toCharArray())
            digits.add(Character.getNumericValue(c));
    }

    private static void validateInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다.");
        }
    }

    private static void validateLength(String inputString) {
        if (inputString.length() != Answer.LENGTH_OF_ANSWER)
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
    }


    public List<Integer> getDigits() {
        return digits;
    }


}
