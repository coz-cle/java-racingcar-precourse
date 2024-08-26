package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.List;

import static racingcar.constant.RaceConstant.MOVE_CONDITION;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> {
            int number = numberGenerator.generateNumber();
            if (canMove(number)) {
                car.move();
            }
        });
    }

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }
}
