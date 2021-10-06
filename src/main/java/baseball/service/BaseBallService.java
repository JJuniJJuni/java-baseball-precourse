package baseball.service;

import baseball.constant.BaseBallConstant;
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
		Score score = baseBallGame.getScore(userInput.getNumber(), baseBallGame.getBaseBall().getNumber());
		if (score.getStrike() == BaseBallConstant.DIGIT_COUNT) {
			baseBallGame.setState(BaseBallConstant.GameState.END);
		}
		return score;
	}

	public void validateEndSelect(String endSelect) {
		if (!endSelect.equals("1") && !endSelect.equals("2")) {
			throw new IllegalArgumentException("입력 값이 옳지 않습니다. 1이나 2를 입력해주세요");
		}
	}
}
