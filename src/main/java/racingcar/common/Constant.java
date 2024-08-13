package racingcar.common;

import java.util.regex.Pattern;

public class Constant {

    public static final String DELIMITER = ",";
    public static final Pattern CAR_NAMES_PATTERN = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");
    public static final Pattern TRY_COUNT_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    public static final String CAR_NAME_WRONG_MESSAGE = "자동차 목록은 쉼표로 구분되고 비어있지 않은 문자여야 합니다.";
    public static final String CAR_NAME_SIZE_OVER_MESSAGE = "자동차 이름은은 1자 이상 5자 이하의 문자여야 합니다.";
    public static final String CAR_NAME_DUPLICATE_MESSAGE = "자동차 목록에 중복된 자동차가 존재합니다.";
    public static final String TRY_COUNT_OUT_OF_RANGE_MESSAGE = "시도 횟수는 1 이상의 정수만 입력 가능합니다.";
    public static final int CAR_NAME_SIZE_LIMIT = 5;

}
