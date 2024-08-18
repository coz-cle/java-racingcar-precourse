package racingcar.domain;

import racingcar.common.util.NumberGenerator;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private Cars(
            final List<String> inputCarNames,
            final NumberGenerator numberGenerator
    ) {
        this.cars = create(inputCarNames);
        this.numberGenerator = numberGenerator;
    }

    private List<Car> create(
            final List<String> inputCarNames
    ) {
        return inputCarNames.stream()
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public static Cars of(
            final List<String> inputCarNames,
            final NumberGenerator numberGenerator
    ) {
        return new Cars(inputCarNames, numberGenerator);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race() {
        cars.forEach(car -> {
            int fowardCondition = numberGenerator.generate();
            car.move(fowardCondition);
        });
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
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
