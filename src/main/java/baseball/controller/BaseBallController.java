package baseball.controller;

import baseball.dto.BaseBallGame;
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
		String input = BaseBallView.inputNumber();
		if (isNotRightInput(input)) {
			return true;
		}
		return false;
	}

	private boolean isNotRightInput(String input) {
		try {
			baseBallService.validateInputValue(input);
		} catch (IllegalArgumentException e) {
			BaseBallView.error(e.getMessage());
			return true;
		}
		return false;
	}

	private void start() {
		baseBallGame = new BaseBallGame();
	}
}
