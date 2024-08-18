package racingcar.controller;

import racingcar.doamin.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        outputView.printInputRacing();
        CarList cars = inputView.inputCarName();

        outputView.printInputTryCount();
        int tryCount = inputView.inputTryCount();
        outputView.printRacingStart();
        moveAllCar(cars, tryCount);

        // TODO 우승자 출력
    }

    private void moveAllCar(CarList cars, int tryCount) {
        IntStream.range(0, tryCount).forEach(index -> {
            cars.moveAll();
            outputView.printRacingLog(cars);
        });
    }

}
