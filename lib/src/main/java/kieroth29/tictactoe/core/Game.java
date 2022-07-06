package kieroth29.tictactoe.core;

import java.io.IOException;

import kieroth29.tictactoe.Constants;
import kieroth29.tictactoe.score.FileScoreManager;
import kieroth29.tictactoe.score.ScoreManager;
import kieroth29.tictactoe.ui.UI;

public class Game {
	
	private Board board = new Board();
	private Player[] players = new Player[Constants.PLAYER_SYMBOLS.length];
	private int currentPlayerIndex = -1;
	private ScoreManager scoreManager;
	
	public void play() throws IOException{
		scoreManager = createScoreManager();
		
		UI.printGameTitle();
		
		for(int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}
		
		board.print();
		Player currentPlayer = nextPlayer();
					
		while(!board.isFull()) {
			board.print();
			
			boolean win;
			try {
				win = currentPlayer.play();
			} catch(InvalidMoveException e) {
				UI.printText("ERRO: " + e.getMessage());
				continue;
			}
			
			if(win){
				scoreManager.saveScore(currentPlayer);
				UI.printText("Parabéns " + currentPlayer.getName() + ", você venceu!");
				return;
			}
			
			currentPlayer = nextPlayer();
		}
		
		board.print();
		UI.printText("O tabuleiro está cheio, ocorreu um empate.");
		return;
	}
	
	private Player createPlayer(int index) {	
		String name = UI.readInput("Nome do jogador " + (index + 1) + ": ");
		char symbol = Constants.PLAYER_SYMBOLS[index];
		
		Player player = new Player(name, board, symbol);
		Integer score = scoreManager.getScore(player);
		
		if(score != null) {
			UI.printText("O jogador '" + name + "' já possui " + score + " vitórias!");
		}
		
		UI.printText("O jogador " + name + " usará o símbolo " + symbol + ".");
		
		return player;
		
	}
	
	private Player nextPlayer() {
		currentPlayerIndex++;
		
		if(currentPlayerIndex == players.length) {
			currentPlayerIndex = 0;
		}
		
		/*
		if(currentPlayerIndex == players.length) {
			currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		}
		 */
		return players[currentPlayerIndex];
	}
	
	private ScoreManager createScoreManager() throws IOException{
		return new FileScoreManager();
	}
	
}
