package racingcar.controller;

import racingcar.common.CarNameValidator;
import racingcar.common.TryCountValidator;
import racingcar.domain.CarStatusResponse;
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
        CarNameValidator carValidation = validateCarName(carNames);
        Cars cars = createCars(carValidation.CAR_NAMES);
        String tryCount = getTryCountInput();
        TryCountValidator tryCountValidator = validateTryCount(tryCount);
        List<CarStatusResponse> carStatusResponses = carsService.getCarStatus(cars);
        // TODO: 경주 시작 전 자돋차 초기상태 설정 완료!

    }

    private String getCatNamesInput() {
        return InputView.inputCarName();
    }

    private String getTryCountInput() {
        return InputView.inputTryCount();
    }

    private CarNameValidator validateCarName(String carNames) {
        return new CarNameValidator(carNames);
    }

    private TryCountValidator validateTryCount(String tryCount) {
        return new TryCountValidator(tryCount);
    }

    private Cars createCars(List<String> inputCarNames) {
        return carsService.createCars(inputCarNames);
    }

}
