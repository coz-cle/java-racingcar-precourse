package racingcar.handler;

import static racingcar.util.Reader.*;
import static racingcar.util.Validator.attemptCountsValidateCheck;
import static racingcar.util.Validator.carNamesValidateCheck;

public class InputHandler {
    public String[] inputCarNames() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
                String[] carNames = nextLine().split(",");
                carNamesValidateCheck(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputAttempts() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?\n");
                String number = next();
                attemptCountsValidateCheck(number);
                return Integer.parseInt(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
