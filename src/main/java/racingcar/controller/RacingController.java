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

        moveAllCar(cars, tryCount);
        findWinner(cars);
    }

    private void moveAllCar(CarList cars, int tryCount) {
        outputView.printRacingStart();
        IntStream.range(0, tryCount).forEach(index -> {
            cars.moveAll();
            outputView.printRacingLog(cars);
        });
    }

    private void findWinner(CarList cars) {
        outputView.printWinner(cars);
    }

}
