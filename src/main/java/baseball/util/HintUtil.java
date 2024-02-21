package baseball.util;

import baseball.vo.Answer;

public class HintUtil {

    public static int calculateStrikes (Answer answer, int number) {
        int strikeCount = 0;

        int numberHundredsDigit = number/100;
        int numberTensDigit = number/10%10;
        int numberUnitDigit = number%10;

        if(answer.getHundredsDigit() == numberHundredsDigit) strikeCount++;
        if(answer.getTensDigit() == numberTensDigit) strikeCount++;
        if(answer.getUnitDigit() == numberUnitDigit) strikeCount++;

        return strikeCount;
    }

    public static int calculateBalls (Answer answer, int number) {
        int ballCount = 0;

        int numberHundredsDigit = number/100;
        int numberTensDigit = number/10%10;
        int numberUnitDigit = number%10;

        if(numberHundredsDigit == answer.getTensDigit() ||
                numberHundredsDigit == answer.getUnitDigit()) ballCount++;
        if(numberTensDigit == answer.getHundredsDigit() ||
                numberTensDigit == answer.getUnitDigit()) ballCount++;
        if(numberUnitDigit == answer.getHundredsDigit() ||
                numberUnitDigit == answer.getTensDigit()) ballCount++;

        return ballCount;
    }


}
