package baseball.controller;

import baseball.dto.BaseBall;
import baseball.dto.BaseBallGame;
import baseball.dto.Score;
import baseball.service.BaseBallService;
import baseball.view.BaseBallView;

public class BaseBallController {
	BaseBallGame baseBallGame;
	private static final BaseBallService baseBallService = new BaseBallService();

	public void run() {
		start();
		proceed();
	}

	private void proceed() {
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
		if (baseBallGame.isEnd()) {
			return false;
		}
		BaseBallView.score(score);
		return true;
	}

	private void start() {
		baseBallGame = new BaseBallGame();
	}
}
