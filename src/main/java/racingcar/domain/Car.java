package racingcar.domain;

import racingcar.util.Validator;

import java.util.List;

import static racingcar.util.Validator.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    // 추가 기능 구현

    public String getName() {
        return name;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
