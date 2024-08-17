package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.running.Round;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final List<Car> cars;
	private final int totalRound;
	private final List<Round> results = new ArrayList<>();
	
	public Game(List<Car> cars, int totalRound) {
		this.cars = cars;
		this.totalRound = totalRound;
	}
	
	public final void run() {
		int count = this.totalRound;
		while (count > 0) {
			startRacing();
			count--;
			int thisRound = this.totalRound - count;
			writeResult(thisRound, this.cars);
		}
	}
	
	public List<Round> getResults() {
		if (isRunning()) {
			throw new IllegalStateException("게임을 진행중이다.");
		}
		return this.results;
	}
	
	private boolean isRunning() {
		return this.totalRound < this.results.size();
	}
	
	private void startRacing() {
		cars.forEach(car -> {
			int pickNumber = Randoms.pickNumberInRange(1, 9);
			if (isGo(pickNumber)) {
				car.addPosition();
			}
		});
	}
	
	private boolean isGo(int pickNumber) {
		return pickNumber >= 4;
	}
	
	private void writeResult(int thisRound, List<Car> cars) {
		Round round = new Round(thisRound);
		round.createResult(cars);
		addResults(round);
	}
	
	private void addResults(Round round) {
		this.results.add(round);
	}
	
	@Override
	public String toString() {
		return "Game{" +
				"cars=" + cars +
				", totalRound=" + totalRound +
				", results=" + results +
				'}';
	}
}
