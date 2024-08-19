package racingcar.Input;

import racingcar.utils.InputScanner;

public class TotalRoundProcessor extends InputProcessor<Integer> {
	
	private final static String TOTAL_ROUND_REQUIRED_MESSAGE = "시도할 횟수는 반드시 입력되어야 한다.";
	private final static String TOTAL_ROUND_ONLY_NUMBER_MESSAGE = "시도할 횟수는 숫자만 입력되어야 한다.";
	private final static String TOTAL_ROUND_MINIMUM_MESSAGE = "시도할 횟수는 1 이상이여야 한다.";
	
	public TotalRoundProcessor(InputScanner inputScanner) {
		super(inputScanner);
	}
	
	@Override
	Integer validateInput(String input) {
		validateTotalRound(input);
		return convertStringToInt(input);
	}
	
	private void validateTotalRound(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throwException(TOTAL_ROUND_REQUIRED_MESSAGE);
		}
		
		if (!isConvertibleToInt(inputValue)) {
			throwException(TOTAL_ROUND_ONLY_NUMBER_MESSAGE);
		}
		
		final int totalRound = convertStringToInt(inputValue);
		if (totalRound < 1) {
			throwException(TOTAL_ROUND_MINIMUM_MESSAGE);
		}
	}
	
	private boolean isConvertibleToInt(String inputValue) {
		try {
			Integer.parseInt(inputValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private int convertStringToInt(String inputValue) {
		return Integer.parseInt(inputValue);
	}
}
