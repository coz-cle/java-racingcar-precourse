package racingcar;

import racingcar.config.AppConfig;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.service.CarRacingService;

import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		CarRacingService carRacingService = appConfig.carRacingService();
		
		// 경주 준비
		Game initGame = carRacingService.initialize();
		
		// 경주 실행
		List<Round> gameResults = carRacingService.race(initGame);
		
		// 경주 완료
		carRacingService.finish(gameResults);
	}
}
