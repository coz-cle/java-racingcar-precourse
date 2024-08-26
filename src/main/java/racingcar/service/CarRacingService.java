package racingcar.service;

import racingcar.domain.Game;
import racingcar.domain.Round;

import java.util.List;

public interface CarRacingService {
	/* 경주 준비 */
	Game initialize();
	
	/* 경주 실행 */
	List<Round> race(Game game);
	
	/* 경주 완료 */
	void finish(List<Round> gameResults);
}
