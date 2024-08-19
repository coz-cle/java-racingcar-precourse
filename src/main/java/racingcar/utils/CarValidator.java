package racingcar.utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.utils.ErrorMessage.INVALID_LENGTH;

public final class CarValidator {

    private CarValidator() {
        // 인스턴스화 방지
    }

    public static void validateLengthAndName(String carName) {
        validateLength(carName);
        validateCarName(carName);
    }

    /**
     * 자동차 이름에 대한 글자수 검사
     *
     * @param carName
     */
    public static void validateLength(String carName) {
        int length = carName.length();
        if (length > Consts.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
        if (StringUtils.isBlank(carName)) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }

    /**
     * 자동차 이름에 대한 유효성 검사
     *
     * @param carName
     */
    public static void validateCarName(String carName) {
        boolean matches = Pattern.matches("^[a-zA-Z0-9가-힣]+$", carName);
        if (!matches) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }
}
