package racingcar.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    private Car(final String name) {
        this.name = name;
    }
    public void move() {
        // TODO: 자동차 전진 도메인 로직 구현 필요!
    }

    public static Car create(final String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object diffCar) {
        if (this == diffCar) return true;
        if (diffCar == null || getClass() != diffCar.getClass()) return false;
        Car car = (Car) diffCar;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
