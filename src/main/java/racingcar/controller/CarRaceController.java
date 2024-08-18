package racingcar.controller;

import racingcar.common.util.RandomNumberGenerator;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.dto.RaceResultResponse;
import racingcar.service.CarsService;
import racingcar.service.RaceService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
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
        CarNameValidator carNames = getCatNamesInput();
        Cars cars = createCars(carNames.CAR_NAMES);

        // 경주 시도횟수 입력 및 객체화
        TryCountValidator tryCount = getTryCountInput();
        Race race = createRace(tryCount.TRY_COUNT);
        int roundCount = race.getRoundCount();

        // 자동차 경주 시작 및 진행과정 출력
        printRaceResult(cars, roundCount);

        // 우승한 자동차 이름 출력
        printRaceWinner(cars);
    }

    private CarNameValidator getCatNamesInput() {
        try {
            return new CarNameValidator(InputView.inputCarName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCatNamesInput();
        }
    }

    private TryCountValidator getTryCountInput() {
        try {
            return new TryCountValidator(InputView.inputTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCountInput();
        }
    }

    private Cars createCars(
            final List<String> inputCarNames
    ) {
        return carsService.createCars(inputCarNames, numberGenerator);
    }

    private Race createRace(
            final String tryCount
    ) {
        return raceService.createRace(tryCount);
    }

    private void printRaceResult(
            final Cars cars,
            final int roundCount
    ) {
        List<RaceResultResponse> raceResult = raceService.getRaceResult(cars, roundCount);
        outputView.printRaceResult(raceResult);
    }

    private void printRaceWinner(
            final Cars cars
    ) {
        List<String> raceWinnerCarNames = raceService.getRaceWinnerCarNames(cars);
        outputView.printRaceWinner(raceWinnerCarNames);
    }

}
