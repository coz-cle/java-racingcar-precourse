package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
	
	@Override
	public int pickNumberInRange(int start, int end) {
		return Randoms.pickNumberInRange(start, end);
	}
}
