package racingcar.Input;

import racingcar.utils.InputScanner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameProcessor extends InputProcessor<List<String>> {
	
	private static final String CAR_NAME_REQUIRED_MESSAGE = "자동차의 이름은 하나라도 입력되어야 한다.";
	private static final String CAR_NAME_NON_DUPLICATE_MESSAGE = "자동차의 이름은 중복되지 않아야 한다.";
	private static final String CAR_NAME_NOT_EMPTY_MESSAGE = "자동차의 이름은 공백이 아니여야 한다.";
	private static final String CAR_NAME_NOT_BLANK_MESSAGE = "자동차의 이름에는 공백이 없어야 한다.";
	private static final String CAR_NAME_LIMITS_MESSAGE = "자동차의 이름은 5자 이하여야 한다.";
	
	public CarNameProcessor(InputScanner inputScanner) {
		super(inputScanner);
	}
	
	@Override
	List<String> validateInput(String input) {
		List<String> names = Arrays.asList(input.split(","));
		
		validateCarNames(names);
		for (String name : names) {
			validateCarName(name);
		}
		return names;
	}
	
	private void validateCarNames(List<String> names) {
		if (names == null || names.isEmpty()) {
			super.throwException(CAR_NAME_REQUIRED_MESSAGE);
		}
		
		Set<String> nameSet = new HashSet<>(names);
		if (nameSet.size() != names.size()) {
			super.throwException(CAR_NAME_NON_DUPLICATE_MESSAGE);
		}
	}
	
	private void validateCarName(String name) {
		
		if (name == null || name.isEmpty()) {
			super.throwException(CAR_NAME_NOT_EMPTY_MESSAGE);
		}
		
		if (name.contains(" ")) {
			super.throwException(CAR_NAME_NOT_BLANK_MESSAGE);
		}
		
		if (name.length() > 5) {
			super.throwException(CAR_NAME_LIMITS_MESSAGE);
		}
		
		
	}
}
