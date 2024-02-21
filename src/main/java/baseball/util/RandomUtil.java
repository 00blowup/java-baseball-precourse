package baseball.util;

import baseball.vo.Answer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RandomUtil {

    public Answer generateAnswer() {
        List<Integer> oneToNine = new ArrayList<>();
        for(int i=1; i<10; i++) oneToNine.add(i);

        Answer answer = new Answer(oneToNine.remove(Randoms.pickNumberInRange(0,8)),
                oneToNine.remove(Randoms.pickNumberInRange(0,7)),
                oneToNine.remove(Randoms.pickNumberInRange(0,6)));

        return answer;
    }
}
