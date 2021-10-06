package baseball.view;

import nextstep.utils.Console;

public class BaseBallView {
	public static String inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static void error(String msg) {
		System.out.println("[ERROR] " + msg);
	}
}
