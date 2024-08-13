package racingcar.view;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름을 입력받을 수 있다.")
    void inputCarName() {
        // given
        System.setIn(new ByteArrayInputStream("tjmoon,sekim,smkim,kyu".getBytes()));
        // when
        String result = InputView.inputCarName();
        // then
        assertThat(result).isEqualTo("tjmoon,sekim,smkim,kyu");
    }

    @Test
    @DisplayName("경주 시도 횟수를 입력받을 수 있다.")
    void inputTryCount() {
        // given
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        // when
        String result = InputView.inputTryCount();
        // then
        assertThat(result).isEqualTo("5");
    }

}
