package racingcar.controller;

import racingcar.common.CarNameValidator;
import racingcar.common.TryCountValidator;
import racingcar.domain.Cars;
import racingcar.service.CarsService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController {

    private final InputView inputView;
    private final OutputView outputView;

    private final CarsService carsService;

    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        carsService = new CarsService();
    }

    public void startRace() {
        String carNames = getCatNamesInput();
        CarNameValidator carValidation = new CarNameValidator(carNames);
        Cars cars = createCars(carValidation.CAR_NAMES);
        // TODO: 자동차 목록 유효성 검사 및 객체화 완료

        String tryCount = getTryCountInput();
        TryCountValidator tryCountValidator = new TryCountValidator(tryCount);
        // TODO: 경주 시도횟수 유효성 검사 완료

    }

    private Cars createCars(List<String> inputCarNames) {
        return carsService.createCars(inputCarNames);
    }


    private String getCatNamesInput() {
        return InputView.inputCarName();
    }

    private String getTryCountInput() {
        return InputView.inputTryCount();
    }

}
