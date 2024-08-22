package racingcar.domain;

import racingcar.handler.OutputHandler;
import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final NumberGenerator numberGenerator;
    private final OutputHandler outputHandler;

    public Race(NumberGenerator numberGenerator, OutputHandler outputHandler) {
        this.numberGenerator = numberGenerator;
        this.outputHandler = outputHandler;
    }

    public void startRace(Cars cars, int attemptCount) {
        moveCars(cars, attemptCount); // 자동차 이동
        List<Car> winner = getWinner(cars); // 우승자 선출
        outputHandler.printWinner(winner); // 우승자 출력
    }

    private void moveCars(Cars cars, int attemptCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            cars.move(numberGenerator);
            outputHandler.printRaceResult(cars); // 이동 결과 출력
        }
    }

    private List<Car> getWinner(Cars cars) {
        int winningPoint = getMaxPosition(cars);
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == winningPoint)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
