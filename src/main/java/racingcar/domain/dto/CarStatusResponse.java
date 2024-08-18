package racingcar.domain.dto;

public class CarStatusResponse {

    private final String carName;
    private final int carPosition;

    private CarStatusResponse(
            final String carName,
            final int carPosition
    ) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarStatusResponse create(final String carName, final int carPosition) {
        return new CarStatusResponse(carName, carPosition);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

}
