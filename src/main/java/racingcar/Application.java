package racingcar;

import racingcar.Input.CarNameProcessor;
import racingcar.Input.ConsoleScanner;
import racingcar.Input.ConsoleScannerImpl;
import racingcar.Input.TotalRoundProcessor;
import racingcar.output.OutputProcessor;
import racingcar.running.Round;

import java.util.ArrayList;
import java.util.List;

public class Application {
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TOTAL_ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private static final String RUNNING_RESULT_OUTPUT_TITLE = "실행 결과";
	private static final String FINAL_WINNER_OUTPUT_PREFIX = "최종 우승자 : ";
	
	public static void main(String[] args) {
		
		// 경주 준비
		Game initGame = initialize();
		
		// 경주 실행
		initGame.run();
		List<Round> gameResults = initGame.getResults();
		
		// 경주 완료
		finish(gameResults);
	}
	
	
	private static Game initialize() {
		ConsoleScanner consoleScanner = new ConsoleScannerImpl();
		
		CarNameProcessor carNameProcessor = new CarNameProcessor(consoleScanner);
		List<String> carNames = carNameProcessor.processInput(CAR_NAME_INPUT_MESSAGE);
		
		TotalRoundProcessor totalRoundProcessor = new TotalRoundProcessor(consoleScanner);
		Integer totalRound = totalRoundProcessor.processInput(TOTAL_ROUND_INPUT_MESSAGE);
		
		List<Car> cars = createCars(carNames);
		
		return new Game(cars, totalRound);
	}
	
	private static List<Car> createCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}
	
	private static void finish(List<Round> gameResults) {
		List<String> outputs = new ArrayList<>();
		OutputProcessor outputProcessor = new OutputProcessor(gameResults);
		
		outputs.add(RUNNING_RESULT_OUTPUT_TITLE);
		List<String> roundResults = outputProcessor.expectedRoundResult();
		outputs.addAll(roundResults);
		
		String winnerNames = outputProcessor.expectedWinnerNames();
		outputs.add(FINAL_WINNER_OUTPUT_PREFIX + winnerNames);
		
		for (String output : outputs) {
			System.out.println(output);
		}
	}
}
