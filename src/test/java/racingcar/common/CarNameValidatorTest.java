package racingcar.common;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.constant.RaceConstant.*;

class CarNameValidatorTest {

    @Test
    @DisplayName("정상적인 자동차 목록을 입력받으면 CarNameValidator 객체를 생성할 수 있다.")
    void validateSuccess() {
        // given
        String inputCarNames = "tjmun,smkim,sekim,kyu";
        // when
        CarNameValidator result = new CarNameValidator(inputCarNames);
        // then
        assertThat(result).isInstanceOf(CarNameValidator.class);
    }

    @Test
    @DisplayName("자동차 목록의 자동차 이름이 문자나 숫자가 아닐 경우 예외가 발생한다.")
    void validateCarNameWrongString() {
        // given
        String inputCarNames = "!!!,smkim,sekim,kyu";
        // when & then
        assertThatThrownBy(() -> new CarNameValidator(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_WRONG_MESSAGE);
    }

    @Test
    @DisplayName("자동차 목록의 자동차 이름이 5자를 초과할 경우 예외가 발생한다.")
    void validateCarNameLimitOver() {
        // given
        String inputCarNames = "tjmoon,smkim,sekim,kyu";
        // when & then
        assertThatThrownBy(() -> new CarNameValidator(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_SIZE_OVER_MESSAGE);
    }

    @Test
    @DisplayName("자동차 목록에서 중복된 자동차 이름이 입력될 경우 예외가 발생한다.")
    void validateCarNameDuplicate() {
        // given
        String inputCarNames = "tjmun,smkim,sekim,tjmun";
        // when & then
        assertThatThrownBy(() -> new CarNameValidator(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE_MESSAGE);
    }

}
