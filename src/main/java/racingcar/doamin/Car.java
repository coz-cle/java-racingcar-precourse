package racingcar.doamin;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Consts;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }


    /**
     * 전진 가능 여부에 따라 현재 위치 변경
     *
     * @return
     */
    public boolean forward() {
        boolean moveFlag = isForward();
        if (moveFlag) {
            position++;
        }
        return moveFlag;
    }

    /**
     * 전진 가능 여부를 확인
     * TODO RandomHolder 인터페이스의 구현체를 사용
     *
     * @return
     */
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
