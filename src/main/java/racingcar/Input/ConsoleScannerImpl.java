package racingcar.Input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleScannerImpl implements ConsoleScanner {
	
	@Override
	public String readLine() {
		final String input = Console.readLine();
		return input;
	}
}
