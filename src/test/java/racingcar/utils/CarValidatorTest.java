package racingcar.utils;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarValidatorTest {

    @Test
    void 자동차_이름은_5자이하만_가능하다() {
        assertThatThrownBy(() -> CarValidator.validateLength("over_length")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_빈값일_수_없다() {
        assertThatThrownBy(() -> CarValidator.validateCarName("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_영어_숫자_한국어만_가능하다() {
        assertThatNoException().isThrownBy(() -> CarValidator.validateCarName("Sonata"));
        assertThatNoException().isThrownBy(() -> CarValidator.validateCarName("K5"));
        assertThatNoException().isThrownBy(() -> CarValidator.validateCarName("현대"));
    }

    @Test
    void 자동차_이름은_특수문자일_수_없다() {
        assertThatThrownBy(() -> CarValidator.validateCarName("@#$%^")).isInstanceOf(IllegalArgumentException.class);
    }


}
