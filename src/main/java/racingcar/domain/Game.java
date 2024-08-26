package racingcar.domain;

import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final InputHandler inputHandler;

    private final Race race;

    public Game(InputHandler inputHandler, Race race) {
        this.inputHandler = inputHandler;
        this.race = race;
    }

    public void start() {
        String[] names = inputHandler.inputCarNames();
        List<Car> carList = Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toList());
        Cars cars = Cars.from(carList);

        int attemptCount = inputHandler.inputAttempts();

        race.startRace(cars, attemptCount);
    }
}
