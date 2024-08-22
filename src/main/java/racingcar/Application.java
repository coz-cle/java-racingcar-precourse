package racingcar;

import racingcar.config.GameConfiguration;
import racingcar.domain.Game;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        GameConfiguration configuration = new GameConfiguration();
        Game raceGame = configuration.game();
        raceGame.start();
    }
}
