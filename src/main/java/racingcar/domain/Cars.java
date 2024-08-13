package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> inputCarNames) {
        this.cars = create(inputCarNames);
    }

    private List<Car> create(List<String> inputCarNames) {
        return inputCarNames.stream()
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public static Cars of(List<String> inputCarNames) {
        return new Cars(inputCarNames);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object diffCars) {
        if (this == diffCars) return true;
        if (diffCars == null || getClass() != diffCars.getClass()) return false;
        Cars cars = (Cars) diffCars;
        return Objects.equals(this.cars, cars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
