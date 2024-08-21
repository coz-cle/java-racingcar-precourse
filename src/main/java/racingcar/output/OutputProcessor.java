package racingcar.output;

import racingcar.domain.Round;

import java.util.*;

public class OutputProcessor {
	private static final String POSITION_FORMATTING_UNIT = "-";
	private static final String RESULT_CONNECTION_STRING = " : ";
	private static final String NEW_LINE = "\n";
	private static final String WINNER_NAMES_SEPARATOR = ", ";
	
	
	private final List<Round> gameResults;
	private int highPosition = 0;
	
	public OutputProcessor(List<Round> gameResults) {
		this.gameResults = gameResults;
	}
	
	/* 실행 결과 출력값 추출 */
	public List<String> extractTotalRoundResult() {
		List<String> resultList = new ArrayList<>();
		for (Round round : this.gameResults) {
			String resultRound = extractRoundResult(round);
			resultList.add(resultRound);
		}
		return resultList;
	}
	
	/* 우승자 출력값 추출 */
	public String extractWinnerNames() {
		// 우승자 조회
		Set<String> winnerNames = new HashSet<>();
		Round lastRound = getLastRound();
		for (Round.CarResult lastRoundResult : lastRound.getCarResults()) {
			if (isSamePosition(lastRoundResult.getPosition())) {
				winnerNames.add(lastRoundResult.getName());
			}
		}
		
		// 우승자 출력값 생성
		String[] winnerNamesArray = winnerNames.toArray(new String[0]);
		return String.join(WINNER_NAMES_SEPARATOR, winnerNamesArray);
	}
	
	/* 라운드별 결과 추출 */
	private String extractRoundResult(Round round) {
		StringBuilder builder = new StringBuilder();
		
		round.getCarResults().stream()
				.filter(Objects::nonNull)
				.forEach(carResult -> formatCarResult(carResult, builder));
		
		return builder.toString();
	}
	
	/* 자동차 전진 결과 포맷팅 */
	private void formatCarResult(Round.CarResult carResult, StringBuilder builder) {
		int position = carResult.getPosition();
		if (isHighPosition(position)) {
			updateHighPosition(position);
		}
		
		builder.append(carResult.getName());
		builder.append(RESULT_CONNECTION_STRING);
		while (position > 0) {
			builder.append(POSITION_FORMATTING_UNIT);
			position--;
		}
		builder.append(NEW_LINE);
	}
	
	private void updateHighPosition(int position) {
		this.highPosition = position;
	}
	
	private boolean isHighPosition(int position) {
		return position > this.highPosition;
	}
	
	private boolean isSamePosition(int position) {
		return position == this.highPosition;
	}
	
	private Round getLastRound() {
		final int lastIndex = this.gameResults.size() - 1;
		return this.gameResults.get(lastIndex);
	}
	
}
