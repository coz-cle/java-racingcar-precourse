package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarName() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요. 자동차 이름은 쉼표를 기준으로 구분하여 입력해주세요.");
            return Console.readLine();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCarName();
        }
    }

    public static String inputTryCount() {
        try {
            System.out.println("경주를 시도할 횟수를 입력해주세요.");
            return Console.readLine();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputTryCount();
        }
    }

}
