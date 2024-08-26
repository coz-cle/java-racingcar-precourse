package racingcar.utils;

public enum ErrorMessage {

    ERROR_PREFIX("[ERROR] "),
    INVALID_EMPTY("자동차 이름은 공백일 수 없습니다"),
    INVALID_LENGTH("자동차 이름은 최소 1자 최대 5자까지 입력 가능합니다."),
    INVALID_CAR_NAME("자동차 이름은 영어,숫자,한글만 입력 가능합니다."),
    INVALID_TRY_COUNT("시도 횟수는 숫자만 입력 가능합니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }

}
