package racingcar.common.enums;

public enum InputMessage implements EnumUtil<String, String>{

    CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요. 자동차 이름은 쉼표를 기준으로 구분하여 입력해주세요."),
    TRY_COUNT_MESSAGE("경주를 시도할 횟수를 입력해주세요.")
    ;

    private final String message;

    InputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }

}
