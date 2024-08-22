package racingcar.config;

import racingcar.domain.Game;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

public class GameConfiguration {
    public Game game() {
        return new Game(inputHandler(), outputHandler());
    }

    public InputHandler inputHandler() {
        return new InputHandler();
    }

    public OutputHandler outputHandler() {
        return new OutputHandler();
    }
}
