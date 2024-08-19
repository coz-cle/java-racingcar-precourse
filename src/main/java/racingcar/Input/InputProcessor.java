package racingcar.Input;

import racingcar.utils.InputScanner;

public abstract class InputProcessor<T> {
	private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";
	
	private final InputScanner inputScanner;
	
	public InputProcessor(InputScanner inputScanner) {
		this.inputScanner = inputScanner;
	}
	
	public final T process() {
		T result;
		while (true) {
			try {
				result = validateInput(inputScanner.readLine());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	protected void throwException(String message) {
		throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + message);
	}
	
	abstract T validateInput(String input);
}
