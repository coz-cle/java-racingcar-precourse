package racingcar.running;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	private final List<CarResult> carResults = new ArrayList<>();
	
	public void createResult(List<Car> cars) {
		for (Car car : cars) {
			CarResult carResult = new CarResult(car.getName(), car.getPosition());
			carResults.add(carResult);
		}
	}
	
	public List<CarResult> getCarResults() {
		return carResults;
	}
	
	@Override
	public String toString() {
		return "Round{" +
				"carResults=" + carResults +
				'}';
	}
	
	public static class CarResult {
		private final String name;
		private final int position;
		
		public CarResult(String name, int position) {
			this.name = name;
			this.position = position;
		}
		
		public String getName() {
			return name;
		}
		
		public int getPosition() {
			return position;
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
