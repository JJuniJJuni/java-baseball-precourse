package baseball;

import baseball.controller.BaseBallController;

public class Application {
	public static final BaseBallController baseBallController = new BaseBallController();

	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현
		baseBallController.run();
	}
}
