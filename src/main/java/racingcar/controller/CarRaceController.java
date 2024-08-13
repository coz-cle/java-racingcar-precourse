package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startRace() {
        // TODO: 경주 시작 비즈니스 구현 필요
    }

}
