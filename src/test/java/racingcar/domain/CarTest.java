package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.doamin.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    Car car = new Car("성붕");

    @Test
    void Car_객체의_이름은_생성자의_인자로_결정된다() {
        assertThat(car.getName()).isEqualTo("성붕");
    }

    @Test
    void 자동차_이름은_5자이하만_가능하다() {
        assertThatThrownBy(() -> new Car("over_length")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_빈값일_수_없다() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void forward_메소드는_현재_위치에서_1_증가한_값을_반환한다() {
        // given
        int position = car.getPosition();
        // when
        if (car.forward()) {
            position++;
        }
        assertThat(car.getPosition()).isEqualTo(position);
    }

}
