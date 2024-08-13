package racingcar.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsServiceTest {

    @Test
    @DisplayName("입력받은 자동차 목록 문자열을 통해 자동차 일급 객체를 생성한다.")
    void createCars() {
        // given
        List<String> inputCarNames = Arrays.asList("tjmoon", "smkim");
        CarsService carsService = new CarsService();
        // when
        Cars result = carsService.createCars(inputCarNames);
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(Cars.class);
            assertThat(result.getCars()).hasSize(2);
        });
    }

}
