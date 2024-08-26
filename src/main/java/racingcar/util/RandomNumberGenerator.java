package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int RANDOM_RANGE = 10;
    private final Random random = new Random();
    @Override
    public int generateNumber() {
        return random.nextInt(RANDOM_RANGE);
    }
}
