package baseball.controller;

import baseball.dto.BaseBall;
import baseball.dto.BaseBallGame;
import baseball.dto.Score;
import baseball.service.BaseBallService;
import baseball.view.BaseBallView;

public class BaseBallController {
	private BaseBallGame baseBallGame = new BaseBallGame();
	private static final BaseBallService baseBallService = new BaseBallService();

	public void run() {
		boolean nextTurn = true;
		while (nextTurn) {
			nextTurn = turn();
		}
	}

	private boolean turn() {
		BaseBall input = new BaseBall(BaseBallView.inputNumber());
		if (isNotRightInput(input)) {
			return true;
		}
		if (!processInput(input)) {
			return false;
		}
		return true;
	}

	private boolean isNotRightInput(BaseBall input) {
		try {
			baseBallService.validateInputValue(input);
		} catch (IllegalArgumentException e) {
			BaseBallView.error(e.getMessage());
			return true;
		}
		return false;
	}

	private boolean processInput(BaseBall input) {
		Score score = baseBallService.compute(baseBallGame, input);
		BaseBallView.score(score);
		if (baseBallGame.isEnd()) {
			return end();
		}
		return true;
	}

	private boolean end() {
		boolean isNotRightSelect = true;
		String endSelect = "";
		BaseBallView.endMessage();
		while (isNotRightSelect) {
			endSelect = BaseBallView.inputEndSelect();
			isNotRightSelect = validateRightSelect(endSelect);
		}
		return playAgain(endSelect);
	}

	private boolean validateRightSelect(String endSelectInput) {
		try {
			baseBallService.validateEndSelect(endSelectInput);
			return false;
		} catch (IllegalArgumentException e) {
			BaseBallView.error(e.getMessage());
			return true;
		}
	}

	private boolean playAgain(String endSelectInput) {
		if (endSelectInput.equals("1")) {
			baseBallGame = new BaseBallGame();
			return true;
		}
		return false;
	}
}
