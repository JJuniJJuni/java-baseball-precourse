package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.dto.BaseBall;

public class BaseBallServiceTest {
	private BaseBallService baseBallService = new BaseBallService();

	@ParameterizedTest
	@ValueSource(strings = {"1", "122", "g12"})
	public void 입력값_오류_검증(String input) {
		assertThrows(IllegalArgumentException.class, () -> baseBallService.validateInputValue(new BaseBall(input)));
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "279"})
	public void 입력값_검증(String input) {
		assertTrue(baseBallService.validateInputValue(new BaseBall(input)));
	}
}
