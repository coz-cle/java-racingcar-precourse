package racingcar.domain;

import java.util.Objects;

import static racingcar.common.constant.RaceConstant.CAR_FORWARD_NUMBER;

public class Car {
    private final String name;
    private int position = 0;

    private Car(
            final String name
    ) {
        this.name = name;
    }

    public void move(
            final int fowordCondition
    ) {
        if(isFowardCar(fowordCondition)) {
            position++;    
        }
    }

    private static boolean isFowardCar(
            final int fowordCondition
    ) {
        return fowordCondition >= CAR_FORWARD_NUMBER;
    }

    public static Car create(
            final String carName
    ) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
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
