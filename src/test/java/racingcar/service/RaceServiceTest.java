package racingcar.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceResultResponse;
import racingcar.mock.MockNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RaceServiceTest {

    @Test
    @DisplayName("입력받은 경주 시도횟수 문자열을 통해 경주 객체를 생성한다.")
    void createRace() {
        // given
        String tryCount = "3";
        CarsService carsService = new CarsService();
        RaceService raceService = new RaceService(carsService);
        // when
        Race result = raceService.createRace(tryCount);
        // then
        assertAll(() -> {
            assertThat(result).isInstanceOf(Race.class);
            assertThat(result.getRoundCount()).isEqualTo(3);
        });
    }

    @Test
    @DisplayName("자동차 경주를 시작시키고 경주가 종료되면 경주 결과 정보를 반환한다.")
    void getRaceResult() {
        // given
        List<String> inputCarNames = Arrays.asList("tjmoon", "smkim", "sekim", "kyu");
        MockNumberGenerator numberGenerator = new MockNumberGenerator();
        Cars cars = Cars.of(inputCarNames, numberGenerator);
        String tryCount = "3";
        CarsService carsService = new CarsService();
        RaceService raceService = new RaceService(carsService);
        Race race = raceService.createRace(tryCount);
        // when
        List<RaceResultResponse> result = raceService.getRaceResult(cars, race.getRoundCount());
        // then
        assertAll(() -> {
            assertThat(result).hasSize(3);
        });
    }

    @Test
    @DisplayName("")
    void startRace() {
        // given
        // when
        // then
    }

}
