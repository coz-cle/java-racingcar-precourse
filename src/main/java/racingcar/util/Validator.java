package racingcar.util;

import java.util.Arrays;

import static racingcar.constant.CarConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.constant.ErrorConstant.ERROR_MESSAGE_PREFIX;

public final class Validator {
    private Validator() {}

    public static void carNamesValidateCheck(String[] carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > CAR_NAME_MAX_LENGTH || carName.isBlank()) {
                throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }

    public static void attemptCountsValidateCheck(String number) {
        try {
            int attempts = Integer.parseInt(number);
            if (attempts <= 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "시도 횟수는 숫자여야 합니다.");
        }
    }
}
