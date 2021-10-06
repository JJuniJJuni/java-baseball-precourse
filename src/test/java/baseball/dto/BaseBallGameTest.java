package baseball.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BaseBallGameTest {
	private BaseBallGame baseBallGame = new BaseBallGame();

	@Test
	public void 스트라이크_계산_검증() {
		assertEquals(baseBallGame.getScore("123", "145").getStrike(), 1);
		assertEquals(baseBallGame.getScore("123", "125").getStrike(), 2);
	}

	@Test
	public void 볼_계산_검증() {
		assertEquals(baseBallGame.getScore("123", "418").getBall(), 1);
		assertEquals(baseBallGame.getScore("123", "291").getBall(), 2);
	}
}
