package racingcar.common.enums;

public enum OutputMessage implements EnumUtil<String, String>{

    CAR_RAGE_RESULT_MESSAGE("실행 결과 \n"),
    CAR_NAME_AND_CAR_POSITION_DELIMITER(" : "),
    CAR_RACE_MARK("-"),
    CAR_RACE_WINNER_MESSAGE("최종 우승자 : "),
    ;

    private final String message;

    OutputMessage(
            final String message
    ) {
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
