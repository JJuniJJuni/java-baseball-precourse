package baseball.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseBallTest {
	@ParameterizedTest
	@ValueSource(strings = {"11", "113"})
	public void 중복_검증(String input) {
		assertTrue(BaseBall.isSameDigit(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "123"})
	public void 미중복_검증(String input) {
		assertFalse(BaseBall.isSameDigit(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "23"})
	public void 길이_오류_검증(String input) {
		assertFalse(BaseBall.isRightLength(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "456"})
	public void 길이_검증(String input) {
		assertTrue(BaseBall.isRightLength(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1ac", "가d2"})
	public void 숫자_오류_검증(String input) {
		assertFalse(BaseBall.isNumberFormat(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "45"})
	public void 숫자_검증(String input) {
		assertTrue(BaseBall.isNumberFormat(input));
	}
}
