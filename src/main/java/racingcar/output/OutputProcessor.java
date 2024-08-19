package racingcar.output;

import racingcar.domain.Round;

import java.util.*;

public class OutputProcessor {
	private static final String POSITION_COUNT_UNIT = "-";
	
	private final List<Round> gameResults;
	private final Queue<Round.CarResult> queue = new LinkedList<>();
	private int highPosition = 0;
	
	public OutputProcessor(List<Round> gameResults) {
		this.gameResults = gameResults;
	}
	
	/* 실행 결과 출력값 추출 */
	public List<String> expectedRoundResult() {
		List<String> result = new ArrayList<>();
		for (Round round : this.gameResults) {
			StringBuilder builder = new StringBuilder();
			this.queue.addAll(round.getCarResults());
			
			while (!this.queue.isEmpty()) {
				Round.CarResult carResult = this.queue.poll();
				int position = carResult.getPosition();
				if (isHighPosition(position)) {
					updateHighPosition(position);
				}
				
				builder.append(carResult.getName());
				builder.append(" : ");
				while (position > 0) {
					builder.append(POSITION_COUNT_UNIT);
					position--;
				}
				builder.append("\n");
			}
			
			result.add(builder.toString());
		}
		return result;
	}
	
	/* 우승자 출력값 추출 */
	public String expectedWinnerNames() {
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
		return String.join(", ", winnerNamesArray);
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
