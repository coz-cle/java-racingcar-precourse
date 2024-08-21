package racingcar.Input;

import org.junit.platform.commons.util.StringUtils;
import racingcar.utils.InputScanner;

import java.util.*;

public class CarNameProcessor extends InputProcessor<List<String>> {
	
	private static final String NAME_SEPARATOR = ",";
	private static final String REQUIRED_MESSAGE = "자동차의 이름은 하나라도 입력되어야 한다.";
	private static final String NON_DUPLICATE_MESSAGE = "자동차의 이름은 중복되지 않아야 한다.";
	private static final String NOT_EMPTY_MESSAGE = "자동차의 이름은 공백이 아니여야 한다.";
	private static final String NOT_SPACE_IN_NAME_MESSAGE = "자동차의 이름에는 공백이 없어야 한다.";
	private static final String LIMITS_MESSAGE = "자동차의 이름은 5자 이하여야 한다.";
	private static final String SPACE = " ";
	private static final int NAME_MAX_LENGTH = 5;
	
	
	public CarNameProcessor(InputScanner inputScanner) {
		super(inputScanner);
	}
	
	@Override
	List<String> validateInput(String input) {
		List<String> names = Arrays.asList(input.split(NAME_SEPARATOR));
		
		validateCarNames(names);
		for (String name : names) {
			validateCarName(name);
		}
		return names;
	}
	
	private void validateCarNames(List<String> names) {
		if (Objects.isNull(names) || names.isEmpty()) {
			super.throwException(REQUIRED_MESSAGE);
		}
		
		Set<String> nameSet = new HashSet<>(names);
		if (nameSet.size() != names.size()) {
			super.throwException(NON_DUPLICATE_MESSAGE);
		}
	}
	
	private void validateCarName(String name) {
		
		if (StringUtils.isBlank(name)) {
			super.throwException(NOT_EMPTY_MESSAGE);
		}
		
		if (name.contains(SPACE)) {
			super.throwException(NOT_SPACE_IN_NAME_MESSAGE);
		}
		
		if (name.length() > NAME_MAX_LENGTH) {
			super.throwException(LIMITS_MESSAGE);
		}
	}
}
