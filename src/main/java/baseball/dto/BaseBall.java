package baseball.dto;

import java.util.HashSet;
import java.util.Set;

import baseball.constant.BaseBallConstant;
import nextstep.utils.Randoms;

public class BaseBall {

	private String number;

	public BaseBall(String number) {
		this.number = number;
	}

	public static BaseBall randomBaseBall() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < BaseBallConstant.DIGIT_COUNT; i++) {
			result.append(randomDigit(result.toString()));
		}
		return new BaseBall(result.toString());
	}

	private static String randomDigit(String result) {
		String digit;
		do {
			digit = String.valueOf(Randoms.pickNumberInRange(BaseBallConstant.MIN_DIGIT, BaseBallConstant.MAX_DIGIT));
		} while (isSameDigit(result + digit));
		return digit;
	}

	public static boolean isSameDigit(String digits) {
		Set<Character> set = new HashSet<>();
		for (char digit : digits.toCharArray()) {
			set.add(digit);
		}
		return digits.length() != set.size();
	}

	public boolean isRightLength() {
		return this.number.length() == BaseBallConstant.DIGIT_COUNT;
	}

	public boolean isNumberFormat() {
		return this.number.matches("^[1-9]+$");
	}

	public String getNumber() {
		return number;
	}
}
