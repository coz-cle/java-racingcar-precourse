package racingcar.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.constant.RaceConstant;
import racingcar.validator.TryCountValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountValidatorTest {

    @Test
    @DisplayName("입력받은 시도 횟수가 1 이상의 정수라면 TryCountValidator 객체를 생성할 수 있다.")
    void validateSuccess() {
        // given
        String inputTryCount = "3";
        // when & then
        TryCountValidator result = new TryCountValidator(inputTryCount);
        assertThat(result).isInstanceOf(TryCountValidator.class);
    }

    @Test
    @DisplayName("입력받은 시도 횟수가 정수가 아닐 경우 예외가 발생한다.")
    void validateTryCountIsNotIntNumber() {
        // given
        String inputTryCount = "0.2";
        // when & then
        assertThatThrownBy(() -> new TryCountValidator(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RaceConstant.TRY_COUNT_OUT_OF_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("입력받은 시도 횟수가 0일 경우 예외가 발생한다.")
    void validateTryCountIsZero() {
        // given
        String inputTryCount = "0";
        // when & then
        assertThatThrownBy(() -> new TryCountValidator(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RaceConstant.TRY_COUNT_OUT_OF_RANGE_MESSAGE);
    }

}
