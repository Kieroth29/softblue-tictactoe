package kieroth29.tictactoe.core;

import kieroth29.tictactoe.Constants;
import kieroth29.tictactoe.ui.UI;

public class Board {
	
	private char [][] matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
	
	public Board() {
		clear();
	}
	
	void clear() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = ' ';
			}
		}
	}
	
	void print() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				UI.printTextWithNoNewLine(String.valueOf(matrix[i][j]));
				if(j + 1 < Constants.BOARD_SIZE) {
					UI.printTextWithNoNewLine(" | ");
				}
			}
			UI.printNewLine();
			
			if(i + 1 < matrix.length) {
				UI.printText("---------");				
			}
		}
	}
	
	public Boolean isFull() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public Boolean play(Player player, Move move) throws InvalidMoveException {
		int i = move.getI();
		int j = move.getJ();
		
		if(i < 0 || j < 0 || i > Constants.BOARD_SIZE || j > Constants.BOARD_SIZE) {
			throw new InvalidMoveException("A jogada inserida ultrapassa os limites do tabuleiro.");
		}
		
		if(matrix[i][j] != ' ') {
			throw new InvalidMoveException("Esta posição já foi preenchida.");
		}
		
		matrix[i][j] = player.getSymbol();
		
		if(checkRows(player)) {
			return true;
		}
		
		if(checkCols(player)) {
			return true;
		}
		
		return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}
	
	private boolean checkRows(Player player) {
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(checkRow(i, player)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkRow(int i, Player player) {
		char symbol = player.getSymbol();
		
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(matrix[i][j] != symbol){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkCols(Player player) {
		for(int j = 0; j < Constants.BOARD_SIZE; j++) {
			if(checkCol(j, player)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkCol(int j, Player player) {
		char symbol = player.getSymbol();
		
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][j] != symbol){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkDiagonal1(Player player) {
		char symbol = player.getSymbol();
		
		for(int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][i] != symbol) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkDiagonal2(Player player) {
		char symbol = player.getSymbol();
		int lastLine = Constants.BOARD_SIZE - 1;
		
		for (int i = lastLine, j = 0; i >= 0; i--, j++) {
			if (matrix[i][j] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	
}
