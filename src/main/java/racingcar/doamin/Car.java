package racingcar.doamin;

import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.util.StringUtils;
import racingcar.utils.Consts;

public class Car {

  private final String name;
  private int position = 0;

  public Car(String name) {
    validateCarName(name);
    this.name = name;
  }

  public void validateCarName(String name) {
    int length = name.length();
    if (length > Consts.MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
    }
    if (StringUtils.isBlank(name)) {
      throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
    }
  }

  public boolean forward() {
    boolean moveFlag = isForward();
    if (moveFlag) {
      position++;
    }
    return moveFlag;
  }

  private boolean isForward() {
    int random = Randoms.pickNumberInRange(Consts.MIN_RANDOM_LENGTH, Consts.MAX_RANDOM_LENGTH);
    return random >= 4;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }


}
