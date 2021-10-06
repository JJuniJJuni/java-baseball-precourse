package baseball.service;

import baseball.dto.BaseBall;
import baseball.dto.BaseBallGame;
import baseball.dto.Score;

public class BaseBallService {

	public boolean validateInputValue(BaseBall input) {
		if (!input.isRightLength()) {
			throw new IllegalArgumentException("길이가 맞지 않습니다. 3개의 서로 다른 숫자로 입력해주세요");
		}

		if (!input.isNumberFormat()) {
			throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
		}

		if (BaseBall.isSameDigit(input.getNumber())) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다");
		}
		return true;
	}

	public Score compute(BaseBallGame baseBallGame, BaseBall userInput) {
		return baseBallGame.getScore(userInput.getNumber(), baseBallGame.getBaseBall().toString());
	}
}
