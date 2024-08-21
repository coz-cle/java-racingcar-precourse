package racingcar.service.impl;

import racingcar.Input.CarNameProcessor;
import racingcar.Input.TotalRoundProcessor;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.output.OutputProcessor;
import racingcar.service.CarRacingService;
import racingcar.utils.InputScanner;
import racingcar.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingServiceImpl implements CarRacingService {
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TOTAL_ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private static final String RUNNING_RESULT_OUTPUT_TITLE = "실행 결과";
	private static final String FINAL_WINNER_OUTPUT_PREFIX = "최종 우승자 : ";
	
	private final InputScanner inputScanner;
	private final NumberGenerator numberGenerator;
	
	public CarRacingServiceImpl(InputScanner inputScanner, NumberGenerator numberGenerator) {
		this.inputScanner = inputScanner;
		this.numberGenerator = numberGenerator;
	}
	
	/* 경주 준비 */
	@Override
	public Game initialize() {
		
		CarNameProcessor carNameProcessor = new CarNameProcessor(inputScanner);
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		List<String> carNames = carNameProcessor.process();
		
		TotalRoundProcessor totalRoundProcessor = new TotalRoundProcessor(inputScanner);
		System.out.println(TOTAL_ROUND_INPUT_MESSAGE);
		Integer totalRound = totalRoundProcessor.process();
		
		List<Car> cars = createCars(carNames);
		
		return new Game(cars, totalRound, numberGenerator);
	}
	
	/* 경주 실행 */
	@Override
	public List<Round> race(Game game) {
		
		game.run();
		
		if (game.isRunning()) {
			throw new IllegalStateException("게임을 진행중이다.");
		}
		
		return game.getRounds();
	}
	
	/* 경주 완료 */
	@Override
	public void finish(List<Round> gameResults) {
		List<String> outputs = new ArrayList<>();
		OutputProcessor outputProcessor = new OutputProcessor(gameResults);
		
		outputs.add(RUNNING_RESULT_OUTPUT_TITLE);
		List<String> roundResults = outputProcessor.extractTotalRoundResult();
		outputs.addAll(roundResults);
		
		final String winnerNames = outputProcessor.extractWinnerNames();
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
