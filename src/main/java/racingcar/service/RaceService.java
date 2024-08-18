package racingcar.service;

import racingcar.domain.dto.CarStatusResponse;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.dto.RaceResultResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceService {

    private final CarsService carsService;

    public RaceService(
            final CarsService carsService
    ) {
        this.carsService = carsService;
    }

    public Race createRace(
            final String tryCount
    ) {
        return Race.of(tryCount);
    }

    public List<RaceResultResponse>getRaceResult(
            final Cars cars,
            final int roundCount
    ) {
        return IntStream.range(0, roundCount)
                .mapToObj(idx -> {
                    startRace(cars);
                    return getResultCarStatus(cars);
                })
                .collect(Collectors.toList());
    }

    public void startRace(
            final Cars cars
    ) {
        cars.race();
    }

    private RaceResultResponse getResultCarStatus(
            final Cars cars
    ) {
        List<CarStatusResponse> carRaceResult = carsService.getCarStatus(cars);
        return RaceResultResponse.create(carRaceResult);
    }

}
