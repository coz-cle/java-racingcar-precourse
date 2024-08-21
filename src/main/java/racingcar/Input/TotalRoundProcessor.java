package racingcar.Input;

import org.junit.platform.commons.util.StringUtils;
import racingcar.utils.InputScanner;

public class TotalRoundProcessor extends InputProcessor<Integer> {
	
	private final static String TOTAL_ROUND_REQUIRED_MESSAGE = "시도할 횟수는 반드시 입력되어야 한다.";
	private final static String TOTAL_ROUND_ONLY_NUMBER_MESSAGE = "시도할 횟수는 숫자만 입력되어야 한다.";
	private final static String TOTAL_ROUND_MINIMUM_MESSAGE = "시도할 횟수는 1 이상이여야 한다.";
	private final static int TOTAL_ROUND_MIN = 1;
	
	public TotalRoundProcessor(InputScanner inputScanner) {
		super(inputScanner);
	}
	
	@Override
	Integer validateInput(String input) {
		if (StringUtils.isBlank(input)) {
			throwException(TOTAL_ROUND_REQUIRED_MESSAGE);
		}
		return convertStringToInt(input);
	}
	
	private int convertStringToInt(String inputValue) {
		
		if (!isConvertibleToInt(inputValue)) {
			throwException(TOTAL_ROUND_ONLY_NUMBER_MESSAGE);
		}
		
		final int totalRound = Integer.parseInt(inputValue);
		if (totalRound < TOTAL_ROUND_MIN) {
			throwException(TOTAL_ROUND_MINIMUM_MESSAGE);
		}
		
		return totalRound;
	}
	
	private boolean isConvertibleToInt(String inputValue) {
		try {
			Integer.parseInt(inputValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
