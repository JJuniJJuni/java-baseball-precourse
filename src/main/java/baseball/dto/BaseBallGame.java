package baseball.dto;

import baseball.constant.BaseBallConstant;

public class BaseBallGame {

	private BaseBallConstant.GameState state;
	private BaseBall baseBall;

	public BaseBallGame() {
		this.state = BaseBallConstant.GameState.START;
		this.baseBall = BaseBall.randomBaseBall();
	}

	public BaseBall getBaseBall() {
		return this.baseBall;
	}

	public static int strikeCount(String answer, String userInput) {
		int cnt = 0;
		for (int i = 0; i < BaseBallConstant.DIGIT_COUNT; i++) {
			cnt += isStrike(answer, userInput, i);
		}
		return cnt;
	}

	private static int isStrike(String answer, String userInput, int idx) {
		return answer.charAt(idx) == userInput.charAt(idx) ? 1 : 0;
	}

	public static int ballCount(String answer, String userInput) {
		int cnt = 0;
		for (int i = 0; i < BaseBallConstant.DIGIT_COUNT; i++) {
			cnt += containSameChar(answer, userInput, i);
		}
		return cnt;
	}

	private static int containSameChar(String answer, String userInput, int idx) {
		int cnt = 0;
		for (int i = 0; i < BaseBallConstant.DIGIT_COUNT; i++) {
			cnt += isBall(answer, userInput, idx, i);
		}
		return cnt;
	}

	private static int isBall(String answer, String userInput, int idx, int currentIdx) {
		return userInput.charAt(idx) == answer.charAt(currentIdx) && idx != currentIdx ? 1 : 0;
	}

	public Score getScore(String userInput, String answer) {
		return new Score(strikeCount(userInput, answer), ballCount(userInput, answer));
	}
}
