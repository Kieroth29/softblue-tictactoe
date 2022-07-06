package kieroth29.tictactoe.score;

import java.io.IOException;

import kieroth29.tictactoe.core.Player;

public interface ScoreManager {

	Integer getScore(Player player);
	
	void saveScore(Player player) throws IOException;
}
