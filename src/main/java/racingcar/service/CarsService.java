package racingcar.service;

import racingcar.common.util.NumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.dto.CarStatusResponse;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarsService {

    public Cars createCars(
            final List<String> inputCarNames,
            final NumberGenerator numberGenerator
    ) {
        return Cars.of(inputCarNames, numberGenerator);
    }

    public List<CarStatusResponse> getCarStatus(
            final Cars carsInfo
    ) {
        List<Car> cars = carsInfo.getCars();
        return cars.stream()
                .map(car -> CarStatusResponse.create(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

}
