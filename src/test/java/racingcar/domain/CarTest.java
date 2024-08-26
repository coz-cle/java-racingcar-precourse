package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.doamin.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {
    Car car = new Car("성붕");

    @Test
    void Car_객체의_이름은_생성자의_인자로_결정된다() {
        assertThat(car.getName()).isEqualTo("성붕");
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
