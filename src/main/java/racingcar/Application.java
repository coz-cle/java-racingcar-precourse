package racingcar;

import java.util.*;

public class Application {
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        // TODO 구현 진행
    }
	private static List<Car> createCars(List<String> carNames){
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}
	
    private static List<String> convertListFrom(String inputValue) {
        List<String> names = Arrays.asList(inputValue.split(","));

        validateCarNames(names);
        for(String name : names){
            name = name.trim();
            validateCarName(name);
        }
		
		return names;
    }

	private static int convertToTotalRound(String totalRound) {
		validateTotalRound(totalRound);
		return convertStringToInt(totalRound);
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
	
	private static void validateTotalRound(String inputValue) {
		if(inputValue == null || inputValue.trim().isEmpty()) {
			throwException("시도할 횟수는 입력되어야 한다.");
		}
		
		if(!isConvertibleToInt(inputValue)){
			throwException("시도할 횟수는 숫자만 입력되아야 한다.");
		}
		
		final int totalRound = convertStringToInt(inputValue);
		if(totalRound <= 0){
			throwException("시도할 횟수는 1 이상이여야 한다.");
		}
	}
	
	private static boolean isConvertibleToInt(String inputValue) {
		try {
			Integer.parseInt(inputValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static int convertStringToInt(String inputValue) {
		return Integer.parseInt(inputValue);
	}
	
    private static void throwException(String message) {
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + message);
    }
}
