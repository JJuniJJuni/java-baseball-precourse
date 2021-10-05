package baseball.dto;

public class BaseBallGame {

	enum State {
		START, END;
	}

	private State state;
	private BaseBall baseBall;

	public BaseBallGame() {
		this.state = State.START;
		this.baseBall = BaseBall.randomBaseBall();
	}

}
