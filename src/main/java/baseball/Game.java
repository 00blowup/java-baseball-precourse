package baseball;

import baseball.domain.Answer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Answer createAnswer() {
        List<Integer> digits = new ArrayList<>();

        for(int i = 0; i< Answer.LENGTH_OF_ANSWER; i++) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if(digits.contains(newNumber)) {
                i--;
                continue;
            }
            digits.add(newNumber);
        }

        return new Answer(digits);
    }



}
