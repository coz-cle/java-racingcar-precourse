package racingcar.config;

import racingcar.service.CarRacingService;
import racingcar.service.impl.CarRacingServiceImpl;
import racingcar.utils.ConsoleInputScanner;
import racingcar.utils.InputScanner;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

/* DI container */
public class AppConfig {
	
	public CarRacingService carRacingService() {
		return new CarRacingServiceImpl(inputScanner(), numberGenerator());
	}
	
	private InputScanner inputScanner() {
		return new ConsoleInputScanner();
	}
	
	private NumberGenerator numberGenerator() {
		return new RandomNumberGenerator();
	}
}
