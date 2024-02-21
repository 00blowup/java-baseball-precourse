package baseball.view;

import baseball.domain.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static Input readGuessingNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return new Input(Console.readLine());
    }

}
