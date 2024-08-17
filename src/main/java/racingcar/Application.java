package racingcar;

import racingcar.Input.CarNameProcessor;
import racingcar.Input.TotalRoundProcessor;

import java.util.ArrayList;
import java.util.List;

public class Application {
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TOTAL_ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	
	public static void main(String[] args) {
		
		// 경주 준비
		Game initGame = initialize();
		
		// 경주 실행
		initGame.run();
		System.out.println("initGame.getResultList():" + initGame.getResults());
		
		// 경주 완료
		
	}
	
	private static Game initialize() {
		
		CarNameProcessor carNameProcessor = new CarNameProcessor();
		List<String> carNames = carNameProcessor.processInput(CAR_NAME_INPUT_MESSAGE);
		
		TotalRoundProcessor totalRoundProcessor = new TotalRoundProcessor();
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
}
