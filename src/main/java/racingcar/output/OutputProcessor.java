package racingcar.output;

import racingcar.running.Round;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OutputProcessor {
	private static final String POSITION_COUNT_UNIT = "-";
	
	private final List<Round> gameResults;
	private int highPosition = 0;
	
	public OutputProcessor(List<Round> gameResults) {
		this.gameResults = gameResults;
	}
	
	/* 실행 결과 출력값 추출 */
	public String expectedRoundResultOutput(Queue<Round.CarResult> queue) {
		String result = null;
		for (Round round : this.gameResults) {
			StringBuilder builder = new StringBuilder();
			queue.addAll(round.getCarResults());
			
			while (!queue.isEmpty()) {
				Round.CarResult carResult = queue.poll();
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
			
			result = builder.toString();
		}
		return result;
	}
	
	/* 우승자 출력값 추출 */
	public String expectedWinnerNamesOutput() {
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
