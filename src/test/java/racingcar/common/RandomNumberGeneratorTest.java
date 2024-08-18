package racingcar.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("generate 메서드는 0부터 9까지의 숫자 중 랜덤 숫자를 반환한다.")
    void generate() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();
        // when
        int result = generator.generate();

        // then
        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThanOrEqualTo(9);
    }

}
