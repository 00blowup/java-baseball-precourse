package baseball.view;

import baseball.domain.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static Input readGuessingNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validateInteger(inputString);
        return new Input(inputString);
    }

    public static boolean readRestartOrQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputCommand = Console.readLine();
        validateInteger(inputCommand);
        if(inputCommand.equals("1")) return true;
        if(inputCommand.equals("2")) return false;
        throw new IllegalArgumentException("커맨드 입력값은 1 또는 2여야 합니다.");
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다.");
        }
    }
}
