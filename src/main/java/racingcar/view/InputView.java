package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.common.InputMessage.*;

public class InputView {

    public static String inputCarName() {
        try {
            OutputView.printMessage(CAR_NAMES_MESSAGE.getValue());
            return Console.readLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printMessage(exception.getMessage());
            return inputCarName();
        }
    }

    public static String inputTryCount() {
        try {
            OutputView.printMessage(TRY_COUNT_MESSAGE.getValue());
            return Console.readLine();
        } catch (IllegalArgumentException exception) {
            OutputView.printMessage(exception.getMessage());
            return inputCarName();
        }
    }

}
