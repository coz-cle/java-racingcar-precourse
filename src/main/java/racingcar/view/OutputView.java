package racingcar.view;

import racingcar.doamin.CarList;

import static racingcar.utils.PrintMessage.*;

public class OutputView {

    public void printInputRacing() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT.getMessage());
    }

    public void printRacingStart() {
        System.out.println(PRINT_RACING_RESULT.getMessage());
    }

    public void printRacingLog(CarList carList) {
        carList.printLog();
    }

    public void printWinner(CarList carList) {

    }
}
