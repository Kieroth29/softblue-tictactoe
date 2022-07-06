package kieroth29.tictactoe;

import java.io.IOException;

import kieroth29.tictactoe.core.Game;

/**
 * @author Kieroth
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		Game g = new Game();
		
		g.play();
	}

}
