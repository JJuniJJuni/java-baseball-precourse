package baseball.dto;

public class Score {
	private int strike;
	private int ball;

	public Score(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}
}
