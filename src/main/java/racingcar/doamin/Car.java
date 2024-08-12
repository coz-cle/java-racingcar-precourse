package racingcar.doamin;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Consts;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
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
