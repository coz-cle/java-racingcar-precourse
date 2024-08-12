package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.doamin.CarList;

public class InputView {

    public void inputCarName() {
        String carNames = Console.readLine();
        CarList carList = new CarList();
        carList.add(carNames);
    }

    public int inputTryCount() {
        // TODO Validation 추가
        String tryCount = Console.readLine();
        return Integer.parseInt(tryCount);
    }


}
