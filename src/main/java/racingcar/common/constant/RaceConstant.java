package racingcar.common.constant;

import java.util.regex.Pattern;

public class RaceConstant {

    // 자동차 구분을 위한 콤마 구분
    public static final String DELIMITER = ",";
    public static final String WINNER_DELIMITER = ", ";

    /**
     * CAR_NAMES_PATTERN: 콤마(,)로 나누어진 한글, 영어, 숫자로 이루어진 자동차 목록 문자열을 검증할 정규식 패턴
     * TRY_COUNT_PATTERN: 자연수 형식의 문자열로 이루어진 시도횟수를 검증할 정규식 패턴
     */
    public static final Pattern CAR_NAMES_PATTERN = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + DELIMITER + "]*[가-힣\\w]$");
    public static final Pattern TRY_COUNT_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    // 자동차 이름 길이 5자 제한
    public static final int CAR_NAME_SIZE_LIMIT = 5;

    // 자동차갸 전진할 수 있는 최소 숫자
    public static final int CAR_FORWARD_NUMBER = 4;

    /**
     * 자동차 전진 조건을 위한 랜덤 난수 발생을 위한 최소 및 최대 숫자 범위
     */
    public static final int MIN_RACE_MOVE_NUMBER = 0;
    public static final int MAX_RACE_MOVE_NUMBER = 9;

    // 예외 메시지
    public static final String ERROR = "[ERROR] ";
    public static final String CAR_NAME_WRONG_MESSAGE = ERROR + "자동차 목록은 쉼표로 구분되고 비어있지 않은 문자여야 합니다.";
    public static final String CAR_NAME_SIZE_OVER_MESSAGE = ERROR + "자동차 이름은 1자 이상 5자 이하의 문자여야 합니다.";
    public static final String CAR_NAME_DUPLICATE_MESSAGE = ERROR + "자동차 목록에 중복된 자동차가 존재합니다.";
    public static final String TRY_COUNT_OUT_OF_RANGE_MESSAGE = ERROR + "시도 횟수는 1 이상의 정수만 입력 가능합니다.";

}
