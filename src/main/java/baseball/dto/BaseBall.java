package baseball.dto;

import java.util.HashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseBall {
	public static final int DIGIT_COUNT = 3;
	private static final int MIN_DIGIT = 1;
	private static final int MAX_DIGIT = 9;
	private String number;

	public BaseBall(String number) {
		this.number = number;
	}

	public static BaseBall randomBaseBall() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < DIGIT_COUNT; i++) {
			result.append(randomDigit(result.toString()));
		}
		return new BaseBall(result.toString());
	}

	private static String randomDigit(String result) {
		String digit;
		do {
			digit = String.valueOf(Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT));
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

	public static boolean isRightLength(String digits) {
		return digits.length() == DIGIT_COUNT;
	}

	public static boolean isNumberFormat(String input) {
		return input.matches("^[1-9]+$");
	}

}
