package racingcar.running;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	private final int roundNo;
	private final List<CarResult> carResults = new ArrayList<>();
	
	public Round(int roundNo) {
		this.roundNo = roundNo;
	}
	
	public void createResult(List<Car> cars) {
		for (Car car : cars) {
			CarResult carResult = new CarResult(car.getName(), car.getPosition());
			carResults.add(carResult);
		}
	}
	
	@Override
	public String toString() {
		return "Round{" +
				"roundNo=" + roundNo +
				", carResults=" + carResults +
				'}';
	}
	
	public static class CarResult {
		private final String name;
		private final int position;
		
		public CarResult(String name, int position) {
			this.name = name;
			this.position = position;
		}
		
		@Override
		public String toString() {
			return "CarResult{" +
					"carName='" + name + '\'' +
					", carPosition=" + position +
					'}';
		}
	}
}
