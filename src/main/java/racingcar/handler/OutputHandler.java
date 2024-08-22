package racingcar.handler;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {
    public void printRaceResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winner) {
        String winnerName = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerName);
    }
}
