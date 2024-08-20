package racingcar.common.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.common.constant.RaceConstant.MAX_RACE_MOVE_NUMBER;
import static racingcar.common.constant.RaceConstant.MIN_RACE_MOVE_NUMBER;


public class RandomNumberGenerator implements NumberGenerator {

    // 0에서 9까지의 숫자중 랜덤으로 난수 제공
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RACE_MOVE_NUMBER, MAX_RACE_MOVE_NUMBER);
    }

}
