package racingcar.validator;

import racingcar.common.constant.RaceConstant;

import static racingcar.common.constant.RaceConstant.TRY_COUNT_PATTERN;

public class TryCountValidator {

    public final String TRY_COUNT;

    public TryCountValidator(
            final String tryCount
    ) {
        TRY_COUNT = tryCount;
        isIntNumber();
    }

    /**
     * 시도 횟수 문자 유효성 검사
     * 정규식 패턴을 통해 1 이상의 정수 여부를 판단
     * 해당 정규식 조건 불만족시 예외 발생
     */
    private void isIntNumber() {
        // String 형식 확인: 앞-0이 아닌 숫자, 이후-숫자
        if (!TRY_COUNT_PATTERN.matcher(TRY_COUNT).matches()) {
            throw new IllegalArgumentException(RaceConstant.TRY_COUNT_OUT_OF_RANGE_MESSAGE);
        }
    }

}
