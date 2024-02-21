package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String readNumber() {
        String input = Console.readLine();

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다. 세 자리 정수를 입력하세요.");
        }

        if(input.length() != 3)
            throw new IllegalArgumentException("입력값이 세 자리가 아닙니다. 세 자리 정수를 입력하세요.");

        return input;
    }
}
