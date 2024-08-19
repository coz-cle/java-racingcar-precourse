package racingcar.service;

import racingcar.Input.CarNameProcessor;
import racingcar.Input.TotalRoundProcessor;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.output.OutputProcessor;
import racingcar.utils.ConsoleInputScanner;
import racingcar.utils.InputScanner;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingService {
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TOTAL_ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private static final String RUNNING_RESULT_OUTPUT_TITLE = "실행 결과";
	private static final String FINAL_WINNER_OUTPUT_PREFIX = "최종 우승자 : ";
	
	public Game initialize() {
		final InputScanner inputScanner = new ConsoleInputScanner();
		
		CarNameProcessor carNameProcessor = new CarNameProcessor(inputScanner);
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		List<String> carNames = carNameProcessor.process();
		
		TotalRoundProcessor totalRoundProcessor = new TotalRoundProcessor(inputScanner);
		System.out.println(TOTAL_ROUND_INPUT_MESSAGE);
		Integer totalRound = totalRoundProcessor.process();
		
		List<Car> cars = createCars(carNames);
		
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		return new Game(cars, totalRound, numberGenerator);
	}
	
	public void finish(List<Round> gameResults) {
		List<String> outputs = new ArrayList<>();
		OutputProcessor outputProcessor = new OutputProcessor(gameResults);
		
		outputs.add(RUNNING_RESULT_OUTPUT_TITLE);
		List<String> roundResults = outputProcessor.expectedRoundResult();
		outputs.addAll(roundResults);
		
		final String winnerNames = outputProcessor.expectedWinnerNames();
		outputs.add(FINAL_WINNER_OUTPUT_PREFIX + winnerNames);
		
		for (String output : outputs) {
			System.out.println(output);
		}
	}
	
	private List<Car> createCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}
}
