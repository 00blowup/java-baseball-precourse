package baseball.util;

import baseball.vo.Answer;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public Answer generateAnswer() {
        Answer answer = new Answer(Randoms.pickNumberInRange(1,9),
                Randoms.pickNumberInRange(1,9),
                Randoms.pickNumberInRange(1,9));

        return answer;
    }
}
