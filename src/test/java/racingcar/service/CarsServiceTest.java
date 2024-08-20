package racingcar.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarStatusResponse;
import racingcar.domain.Cars;
import racingcar.mock.MockNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsServiceTest {

    @Test
    @DisplayName("입력받은 자동차 목록 문자열을 통해 자동차목록 일급 객체를 생성한다.")
    void createCars() {
        // given
        List<String> inputCarNames = Arrays.asList("tjmoon", "smkim");
        MockNumberGenerator numberGenerator = new MockNumberGenerator();
        CarsService carsService = new CarsService();
        // when
        Cars result = carsService.createCars(inputCarNames, numberGenerator);
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(Cars.class);
            assertThat(result.getCars()).hasSize(2);
        });
    }

    @Test
    @DisplayName("자동차 목록 일급객체 정보를 통해 자동차별 상태정보를 가져올 수 있다.")
    void getCarStatus() {
        // given
        List<String> inputCarNames = Arrays.asList("tjmoon", "smkim");
        MockNumberGenerator numberGenerator = new MockNumberGenerator();
        CarsService carsService = new CarsService();
        Cars cars = carsService.createCars(inputCarNames, numberGenerator);
        // when
        List<CarStatusResponse> result = carsService.getCarStatus(cars);
        // then
        assertThat(result).hasSize(2);
    }

}
