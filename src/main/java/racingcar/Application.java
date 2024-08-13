package racingcar;

import java.util.*;

public class Application {
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        // TODO 구현 진행
    }

    private static List<Car> convertCarListFrom(String inputValue) {
        List<Car> cars = new ArrayList<>();

        List<String> names = Arrays.asList(inputValue.split(","));

        validateCarNames(names);
        for(String name : names){
            name = name.trim();
            validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throwException("자동차의 이름은 공백이 아니여야 한다.");
        }

        if (name.length() > 5) {
            throwException("자동차의 이름은 5자 이하여야 한다.");
        }
    }

    private static void validateCarNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throwException("자동차의 이름은 하나라도 입력되어야 한다.");
        }

        Set<String> nameSet = new HashSet<>(names);
        if(nameSet.size() != names.size()) {
            throwException("자동차의 이름은 중복되지 않아야 한다.");
        }
    }

    private static void throwException(String message) {
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + message);
    }
}
