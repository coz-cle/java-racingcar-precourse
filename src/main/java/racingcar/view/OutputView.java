package racingcar.view;

import racingcar.domain.dto.CarStatusResponse;
import racingcar.domain.dto.RaceResultResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.common.enums.OutputMessage.*;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 1. 실행 결과 문자열 삽입
     * 2. 자동차 전진 데이터 삽입 후 출력
     */
    public void printRaceResult(List<RaceResultResponse> raceResult) {
        StringBuilder result = new StringBuilder();
        result.append(CAR_RAGE_RESULT_MESSAGE.getValue());
        raceResult.forEach(raceResultDto -> createRaceResult(raceResultDto, result));
        System.out.println(result.toString().trim());
    }

    private void createRaceResult(RaceResultResponse raceResultDto, StringBuilder result) {
        raceResultDto.getRaceResult()
                .forEach(carStatusDto -> createCarStatus(carStatusDto, result));
        result.append("\n");
    }

    private void createCarStatus(CarStatusResponse carStatusDto, StringBuilder carStatus) {
        carStatus.append(carStatusDto.getCarName())
                .append(CAR_NAME_AND_CAR_POSITION_DELIMITER.getValue())
                .append(repeat(CAR_RACE_MARK.getValue(), carStatusDto.getCarPosition()))
                .append("\n");
    }

    public String repeat(String raceMark, int carPosition) {
        return IntStream.range(0, carPosition)
                .mapToObj(i -> raceMark)
                .collect(Collectors.joining());
    }

}
