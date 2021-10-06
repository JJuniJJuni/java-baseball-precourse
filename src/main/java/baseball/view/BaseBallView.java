package baseball.view;

import baseball.dto.Score;
import nextstep.utils.Console;

public class BaseBallView {
	public static String inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return consoleInput();
	}

	public static void error(String message) {
		System.out.println("[ERROR] " + message);
	}

	public static void score(Score score) {
		int strkeCount = score.getStrike();
		int ballCount = score.getBall();
		String message = getScoreMessage(strkeCount, ballCount);
		System.out.println(message);
	}

	private static String getScoreMessage(int stirkeCount, int ballCount) {
		StringBuilder message = new StringBuilder();
		message.append(stirkeCount > 0 ? String.format("%d스트라이크 ", stirkeCount) : "");
		message.append(ballCount > 0 ? String.format("%d볼", ballCount) : "");
		if (message.length() == 0) {
			message.append("낫싱");
		}
		return message.toString();
	}

	public static void endMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	public static String inputEndSelect() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return consoleInput();
	}

	private static String consoleInput() {
		return Console.readLine().replaceAll(" ", "");
	}
}
