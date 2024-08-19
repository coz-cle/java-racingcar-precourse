package racingcar.doamin;

import racingcar.utils.CarValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static racingcar.utils.PrintMessage.PRINT_WINNER;

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

    public void printWinner() {
        List<Car> winners = carList.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(car -> carList.stream()
                        .filter(c -> c.getPosition() == car.getPosition())
                        .collect(Collectors.toList())
                )
                .orElseThrow(NoSuchElementException::new);

        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println(PRINT_WINNER.getMessage() + winnerNames);

    }


}
