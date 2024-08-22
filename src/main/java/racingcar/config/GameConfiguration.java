package racingcar.config;

import racingcar.domain.Game;
import racingcar.domain.Race;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class GameConfiguration {
    public Game game() {
        return new Game(inputHandler(), race());
    }

    public InputHandler inputHandler() {
        return new InputHandler();
    }

    public OutputHandler outputHandler() {
        return new OutputHandler();
    }

    public Race race() {
        return new Race(numberGenerator(), outputHandler());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
