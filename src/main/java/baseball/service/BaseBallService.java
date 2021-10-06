package baseball.service;

import baseball.dto.BaseBall;
import baseball.dto.BaseBallGame;
import baseball.dto.Score;

public class BaseBallService {

	public boolean validateInputValue(String input) {
		if (!BaseBall.isRightLength(input)) {
			throw new IllegalArgumentException("길이가 맞지 않습니다. 3개의 서로 다른 숫자로 입력해주세요");
		}

		if (!BaseBall.isNumberFormat(input)) {
			throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
		}

		if (BaseBall.isSameDigit(input)) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다");
		}
		return true;
	}

	public Score compute(BaseBallGame baseBallGame, String userInput, String answer) {
		return baseBallGame.getScore(userInput, answer);
	}
}
