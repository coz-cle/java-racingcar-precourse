package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.doamin.CarList;
import racingcar.utils.TryCountValidator;

import static racingcar.utils.ErrorMessage.INVALID_TRY_COUNT;

public class InputView {

    public CarList inputCarName() {
        while (true) {
            try {
                String carNames = Console.readLine();
                CarList carList = new CarList();
                carList.add(carNames);
                return carList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public int inputTryCount() {
        while (true) {
            String tryCount = Console.readLine();
            if (TryCountValidator.isValidTryCount(tryCount)) {
                return Integer.parseInt(tryCount);
            } else {
                System.out.println(INVALID_TRY_COUNT.getMessage());
            }
        }
    }

}
