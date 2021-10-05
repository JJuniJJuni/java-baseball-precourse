package baseball.dto;

import nextstep.utils.Randoms;

public class BaseBall {
	private static final int DIGIT_COUNT = 3;
	private static final int MIN_DIGIT = 1;
	private static final int MAX_DIGIT = 9;
	private String number;

	public BaseBall(String number) {
		this.number = number;
	}

	public static BaseBall randomBaseBall() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < DIGIT_COUNT; i++) {
			result.append(Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT));
		}
		return new BaseBall(result.toString());
	}
}
