package baseball.view;

import baseball.domain.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static Input readGuessingNumber() {
        return new Input(Console.readLine());
    }

}
