package racingcar;

import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.service.RacingGameService;

import java.util.List;

public class Application {
	
	private static final RacingGameService racingGameService = new RacingGameService();
	
	public static void main(String[] args) {
		
		// 경주 준비
		Game initGame = racingGameService.initialize();
		
		// 경주 실행
		initGame.run();
		
		// 경주 완료
		if (!initGame.isRunning()) {
			List<Round> gameResults = initGame.getResults();
			racingGameService.finish(gameResults);
		}
	}
}
