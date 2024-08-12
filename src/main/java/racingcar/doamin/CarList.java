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
            // TODO 구체화예정
            carList.add(new Car(carName));
        }
    }


}
