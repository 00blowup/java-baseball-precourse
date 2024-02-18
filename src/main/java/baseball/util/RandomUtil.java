package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public List<Integer> generateAnswer() {
        List<Integer> result = new ArrayList<>();

        result.add(Randoms.pickNumberInRange(1,9));
        result.add(Randoms.pickNumberInRange(1,9));
        result.add(Randoms.pickNumberInRange(1,9));

        return result;
    }
}
