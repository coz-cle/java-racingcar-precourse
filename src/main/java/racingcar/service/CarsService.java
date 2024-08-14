package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarStatusResponse;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarsService {

    public Cars createCars(final List<String> inputCarNames) {
        return Cars.of(inputCarNames);
    }

    public List<CarStatusResponse> getCarStatus(final Cars carsInfo) {
        List<Car> cars = carsInfo.getCars();
        return cars.stream()
                .map(car -> CarStatusResponse.create(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

}
