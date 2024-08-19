package racingcar.Input;

import racingcar.utils.ConsoleScanner;

public abstract class InputProcessor<T> {
	private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";
	
	private final ConsoleScanner consoleScanner;
	
	public InputProcessor(ConsoleScanner consoleScanner) {
		this.consoleScanner = consoleScanner;
	}
	
	public final T processInput(String message) {
		T result;
		while (true) {
			try {
				System.out.println(message);
				result = validateInput(consoleScanner.readLine());
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
