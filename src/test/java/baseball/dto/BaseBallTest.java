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
}
