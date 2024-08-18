package racingcar.domain;

import java.util.List;

public class RaceResultResponse {

    private final List<CarStatusResponse> carRaceResult;

    private RaceResultResponse(
            final List<CarStatusResponse> carRaceResult
    ) {
        this.carRaceResult = carRaceResult;
    }

    public static RaceResultResponse create(
            final List<CarStatusResponse> carStatusResponses
    ) {
        return new RaceResultResponse(carStatusResponses);
    }

    public List<CarStatusResponse> getRaceResult() {
        return carRaceResult;
    }

}
