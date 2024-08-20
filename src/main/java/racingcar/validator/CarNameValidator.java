package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.common.constant.RaceConstant.*;

public class CarNameValidator {

    private final String INPUT_CAR_NAMES;
    public final List<String> CAR_NAMES;

    public CarNameValidator(
            final String inputCarNames
    ) {
        INPUT_CAR_NAMES = inputCarNames;
        CAR_NAMES = new ArrayList<>(Arrays.asList(inputCarNames.split(DELIMITER)));
        isString();
        isSize();
        isNotDuplicate();
    }

    /**
     * 자동차 목록 문자열 패턴 유효성 검사
     * 정규식 패턴을 통해 맨 앞과 맨 뒤는 반드시 문자, 그 외 중간은 문자와 구분자로 이루어져야 한다.
     * 해당 정규식 조건 불만족시 예외 발생
     */
    private void isString() {
        if (!CAR_NAMES_PATTERN.matcher(INPUT_CAR_NAMES).matches()) {
            throw new IllegalArgumentException(CAR_NAME_WRONG_MESSAGE);
        }
    }

    /**
     * 자동차별 문자 길이 유효성 검사
     * CAR_NAMES를 순회하며 5자 초과인 문자를 발견할 경우 예외 발생
     */
    private void isSize() {
        if (CAR_NAMES.stream().anyMatch(name -> name.isEmpty() || name.length() > CAR_NAME_SIZE_LIMIT)) {
            throw new IllegalArgumentException(CAR_NAME_SIZE_OVER_MESSAGE);
        }
    }

    /**
     * 자동차 목록 중복 유효성 검사
     * CAR_NAMES를 순회하며 중복 여부 판단
     */
    private void isNotDuplicate() {
        if (CAR_NAMES.size() != CAR_NAMES.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_MESSAGE);
        }
    }

}
