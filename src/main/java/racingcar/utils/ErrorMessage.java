package racingcar.utils;

public enum ErrorMessage {

  ERROR_PREFIX("[ERROR]"),

  INVALID_CAR_NAME("자동차 이름은 최소 1자 최대 5자까지 가능합니다.");

  public final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return ERROR_PREFIX.message + message;
  }

}
