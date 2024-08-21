package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputScanner implements InputScanner {
	
	@Override
	public String readLine() {
		final String input = Console.readLine();
		return input;
	}
}
