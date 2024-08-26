package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.doamin.CarList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarListTest {

    CarList carList = new CarList();

    @Test
    void 테스트() {
        // given
        carList.add("test,성은");
        carList.moveAll();

        // when
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        carList.printLog();
        System.setOut(originalOut);

        // Then
        String output = outputStream.toString();
        assertThat(output).contains("test : -");
        assertThat(output).contains("성은 : -");

    }

}
