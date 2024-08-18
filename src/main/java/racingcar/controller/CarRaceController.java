package racingcar.controller;

import racingcar.validator.CarNameValidator;
import racingcar.common.util.RandomNumberGenerator;
import racingcar.validator.TryCountValidator;
import racingcar.domain.CarStatusResponse;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceResultResponse;
import racingcar.service.CarsService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarsService carsService;
    private final RandomNumberGenerator numberGenerator;
    private final RaceService raceService;


    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        carsService = new CarsService();
        numberGenerator = new RandomNumberGenerator();
        raceService = new RaceService(carsService);
    }

    public void race() {
        // 자동차 목록 입력 및 객체화
        String carNames = getCatNamesInput();
        CarNameValidator carValidation = validateCarName(carNames);
        Cars cars = createCars(carValidation.CAR_NAMES);

        // 경주 시도횟수 입력 및 객체화
        String tryCount = getTryCountInput();
        TryCountValidator tryCountValidator = validateTryCount(tryCount);
        Race race = createRace(tryCountValidator.TRY_COUNT);
        int roundCount = race.getRoundCount();

        // 자동차 경주 진행
        printRaceResult(cars, roundCount);

        /**
         * TODO: 우승한 자동차 목록 출력해야함!
         */
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
        return carsService.createCars(inputCarNames, numberGenerator);
    }

    private Race createRace(String tryCount) {
        return raceService.createRace(tryCount);
    }

    private void printRaceResult(Cars cars, int roundCount) {
        List<RaceResultResponse> raceResult = raceService.getRaceResult(cars, roundCount);
        outputView.printRaceResult(raceResult);
    }

}
