package kieroth29.tictactoe.core;

public class Move {
	
	private int i;
	private int j;
	
	public Move(int i, int j) throws InvalidMoveException {
			this.i = i;
			this.j = j;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int iInput) {
		i = iInput;
	}
	
	public int getJ() {
		return j;
	}
	
	public void setJ(int jInput) {
		j = jInput;
	}
	
}
