package baseball.view;

import baseball.dto.Score;
import nextstep.utils.Console;

public class BaseBallView {
	public static String inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
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
		message.append(stirkeCount > 0 ? String.format("%d 스트라이크 ", stirkeCount) : "");
		message.append(ballCount > 0 ? String.format("%d 볼", ballCount) : "");
		if (message.length() == 0) {
			message.append("낫싱");
		}
		return message.toString();
	}
}
