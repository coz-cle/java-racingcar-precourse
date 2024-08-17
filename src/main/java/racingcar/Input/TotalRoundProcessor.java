package racingcar.Input;

public class TotalRoundProcessor extends InputProcessor<Integer> {
	
	@Override
	Integer validateInput(String input) {
		validateTotalRound(input);
		return convertStringToInt(input);
	}
	
	private void validateTotalRound(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throwException("시도할 횟수는 입력되어야 한다.");
		}
		
		if (!isConvertibleToInt(inputValue)) {
			throwException("시도할 횟수는 숫자만 입력되아야 한다.");
		}
		
		final int totalRound = convertStringToInt(inputValue);
		if (totalRound <= 0) {
			throwException("시도할 횟수는 1 이상이여야 한다.");
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
