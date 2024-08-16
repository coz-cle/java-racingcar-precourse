package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private final List<Car> cars;
	private final int totalRound;
	private final List<GameResult> results = new ArrayList<>();
	
	// TODO 난수 생성 로직을 구조화하여 생성자로 받기
	private final Random random = new Random();
	
	public Game(List<Car> cars, int totalRound) {
		this.cars = cars;
		this.totalRound = totalRound;
	}
	
	public void run() {
		int count = this.totalRound;
		
		while (count > 0){
			startRacing();
			count--;
			writeResult(this.totalRound - count);
		}
	}
	
	public List<GameResult> getResultList(){
		if(isRunning()){
			throw new IllegalStateException("게임을 진행중이다.");
		}
		return this.results;
	}
	
	private void startRacing() {
		cars.forEach(car -> {
			if(isGo()){
				car.addPosition();
			}
		});
	}
	
	private void writeResult(int round) {
		this.results.add(new GameResult(round, this.cars));
	}
	
	private boolean isGo(){
		return random.nextInt(10) >= 4;
	}
	
	
	private boolean isRunning(){
		return this.totalRound == this.results.size();
	}
	
	public static class GameResult {
		private final int round;
		private final List<Car> cars;
		
		public GameResult(int round, List<Car> cars) {
			this.round = round;
			this.cars = cars;
		}
	}
}
