package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorUtil implements NumberGeneratorUtil {
    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
