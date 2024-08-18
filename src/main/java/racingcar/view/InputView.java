package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.doamin.CarList;

import java.util.regex.Pattern;

import static racingcar.utils.ErrorMessage.INVALID_TRY_COUNT;

public class InputView {

    public CarList inputCarName() {
        String carNames = Console.readLine();
        CarList carList = new CarList();
        carList.add(carNames);
        return carList;
    }

    public int inputTryCount() {
        String tryCount = Console.readLine();

        boolean matches = Pattern.matches("^[0-9]+$", tryCount);
        if (!matches) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT.getMessage());
        }

        return Integer.parseInt(tryCount);
    }


}
