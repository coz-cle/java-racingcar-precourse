package racingcar.domain;

import racingcar.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final int PICK_RANGE_MIN = 1;
	private static final int PICK_RANGE_MAX = 9;
	
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
		return this.rounds;
	}
	
	public boolean isRunning() {
		return this.totalRound < this.rounds.size();
	}
	
	public void startRacing() {
		this.cars.forEach(car -> {
			int pickNumber = numberGenerator.pickNumberInRange(PICK_RANGE_MIN, PICK_RANGE_MAX);
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
		for (Car car : cars) {
			round.createCarResults(car.getName(), car.getPosition());
		}
		
		addRounds(round);
	}
	
	private void addRounds(Round round) {
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
