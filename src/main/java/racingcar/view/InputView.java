package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public void inputCarName() {
    String input = Console.readLine();
    // TODO Validation 추가
    // TODO CAR 객체 생성
    String[] split = input.split(",");
    for (int i = 0; i < split.length; i++) {
      System.out.println(split[i]);
    }
  }

  public int inputTryCount() {
    // TODO Validation 추가
    String tryCount = Console.readLine();
    return Integer.parseInt(tryCount);
  }
}
