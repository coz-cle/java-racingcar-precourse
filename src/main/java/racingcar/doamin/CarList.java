package racingcar.doamin;

import racingcar.utils.CarValidator;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    List<Car> carList = new ArrayList<>();

    public void add(String carNames) {
        String[] split = carNames.split(",");
        for (int i = 0; i < split.length; i++) {
            String carName = split[i];
            CarValidator.validateLengthAndName(carName);
            carList.add(new Car(carName));
        }
    }

    public void moveAll() {
        carList.stream()
                .forEach(Car::forward);
    }

    public void printLog() {
        carList.stream()
                .forEach(car -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < car.getPosition(); i++) {
                        stringBuffer.append("-");
                    }
                    System.out.printf("%s : %s%n", car.getName(), stringBuffer);
                });
    }


}
