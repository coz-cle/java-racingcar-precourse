package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) {
    // TODO 구현 진행
    OutputView outputView = new OutputView();
    outputView.printInputRacing();

    InputView inputView = new InputView();
    inputView.inputCarName();

    outputView.printInputTryCount();

  }
}
