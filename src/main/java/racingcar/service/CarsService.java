package racingcar.service;

import racingcar.domain.Cars;

import java.util.List;

public class CarsService {

    public Cars createCars(List<String> inputCarNames) {
        return Cars.of(inputCarNames);
    }

}
