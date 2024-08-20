package racingcar.domain;

import racingcar.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final List<Car> cars;
	private final int totalRound;
	private final NumberGenerator numberGenerator;
	private final List<Round> rounds = new ArrayList<>();
	
	public Game(List<Car> cars, int totalRound, NumberGenerator numberGenerator) {
		this.cars = cars;
		this.totalRound = totalRound;
		this.numberGenerator = numberGenerator;
	}
	
	public final void run() {
		int count = this.totalRound;
		while (count > 0) {
			startRacing();
			count--;
			writeResult();
		}
	}
	
	public List<Round> getRounds() {
		if (isRunning()) {
			throw new IllegalStateException("게임을 진행중이다.");
		}
		return this.rounds;
	}
	
	public boolean isRunning() {
		return this.totalRound < this.rounds.size();
	}
	
	public void startRacing() {
		this.cars.forEach(car -> {
			int pickNumber = numberGenerator.pickNumberInRange(1, 9);
			if (isGo(pickNumber)) {
				car.addPosition();
			}
		});
	}
	
	private boolean isGo(int pickNumber) {
		return pickNumber >= 4;
	}
	
	public void writeResult() {
		Round round = new Round();
		round.createResult(this.cars);
		addResults(round);
	}
	
	private void addResults(Round round) {
		this.rounds.add(round);
	}
	
	@Override
	public String toString() {
		return "Game{" +
				"cars=" + cars +
				", totalRound=" + totalRound +
				", results=" + rounds +
				'}';
	}
}
