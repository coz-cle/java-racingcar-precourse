package racingcar.utils;

import java.util.regex.Pattern;

public final class TryCountValidator {

    private TryCountValidator() {
        // 인스턴스화 방지
    }
    public static boolean isValidTryCount(String tryCount) {
        return Pattern.matches("^[0-9]+$", tryCount);
    }

}
