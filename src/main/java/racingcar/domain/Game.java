package racingcar.domain;

import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Game(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {
        String[] names = inputHandler.inputCarNames();
        List<Car> cars = Arrays.stream(names)
                .map(String::trim)
                .map(Car::from)
                .collect(Collectors.toList());
        int attemptCount = inputHandler.inputAttempts();

    }
}
